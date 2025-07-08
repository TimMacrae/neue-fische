package com.oop;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class BankService {
    Set<Account> accounts = new HashSet<>();

    public Account openAccount(Set<Client> clients , BigDecimal balance) {
        Account account = new Account(UUID.randomUUID().toString(), balance, clients);
        accounts.add(account);
        return account;
    }

    public void transfer(String fromAccountId, String toAccountId, BigDecimal amount) {
        Account fromAccount = accounts.stream().filter(account -> account.getAccountId().equals(fromAccountId)).findFirst().orElse(null);
        Account toAccount = accounts.stream().filter(account -> account.getAccountId().equals(toAccountId)).findFirst().orElse(null);

        if(fromAccount == null ) throw new NoSuchElementException("From account not found");
        if(toAccount == null ) throw new NoSuchElementException("To account not found");

        fromAccount.withdraw(amount);
        toAccount.deposit(amount);
    }

    public Set<Account> splitAccounts(String accountNumber){
        Account account = accounts.stream().filter(acc -> acc.getAccountId().equals(accountNumber)).findFirst().orElse(null);
        if(account == null) throw new NoSuchElementException("Account not found");

        BigDecimal balance = account.getBalance();
        int clientCount = account.getClients().size();

        // Calculate per-client share (rounded down) and the remainder
        BigDecimal clientShare = balance.divide(BigDecimal.valueOf(clientCount), 2, RoundingMode.DOWN);
        BigDecimal totalDistributed = clientShare.multiply(BigDecimal.valueOf(clientCount));
        BigDecimal remainder = balance.subtract(totalDistributed);

        account.setBalance(new BigDecimal(remainder.toString()));
        Set<Account> newAccounts = new HashSet<>();

        account.getClients().forEach(client -> {
           Account newAccount = openAccount(Set.of(client) , clientShare);
           newAccounts.add(newAccount);
        });

        return newAccounts;
    }

    public void applyInterestToAllAccounts(BigDecimal interestRate) {
        for (Account account : accounts) {
            BigDecimal balance = account.getBalance();
            BigDecimal interest = balance.multiply(interestRate)
                    .divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_EVEN);
            BigDecimal newBalance = balance.add(interest);
            account.setBalance(newBalance);

        }
    }
}

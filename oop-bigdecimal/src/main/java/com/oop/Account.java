package com.oop;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Account {
    private final String accountId;
    private BigDecimal balance;
    private final Set<Client> clients = new HashSet<>();
    private final List<Transaction> transactions = new ArrayList<>();

    public Account(String accountId, BigDecimal balance, Set<Client> clients) {
        this.accountId = accountId;
        this.balance = balance;
        this.clients.addAll(clients);
    }

    public void deposit(BigDecimal amount) {
        balance = balance.add(amount);
    }
    public void withdraw(BigDecimal amount) {
        balance = balance.subtract(amount);
    }

    public String getAccountId() {
        return accountId;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public Set<Client> getClients() {
        return clients;
    }

    public void addClient(Client client) {
        clients.add(client);
    }

    public Client getClient(String clientId) {
        for (Client client : clients) {
            if(client.customerId().equals(clientId)) return client;
        }
        return null;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}

package com.oop;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class BankServiceTest {
    Client clientMock = new Client(UUID.randomUUID().toString(),"tim","macrae");
    Client clientMockTwo = new Client(UUID.randomUUID().toString(),"georgia","macrae");
    Client clientMockThree = new Client(UUID.randomUUID().toString(),"john","doe");
    BankService bankService = new BankService();

    @Test
    void openAccount_shouldCreatedWithGivenFields() {
       Account newAccount = bankService.openAccount(Set.of(clientMock), BigDecimal.ZERO);
       assertEquals(clientMock,newAccount.getClient(clientMock.customerId()));
       assertEquals(BigDecimal.ZERO,newAccount.getBalance());
    }

    @Test
    void openAccount_shouldNotCreateAccountWithTwoClients() {
        Account newAccountTwo = bankService.openAccount(Set.of(clientMockTwo, clientMock), BigDecimal.ZERO);
        assertEquals(clientMockTwo,newAccountTwo.getClient(clientMockTwo.customerId()));
        assertEquals(clientMock,newAccountTwo.getClient(clientMock.customerId()));
        assertEquals(2,newAccountTwo.getClients().size());
        assertEquals(BigDecimal.ZERO,newAccountTwo.getBalance());
    }

    @Test
    void transfer_shouldTransferTheMoney() {
        Account accountFrom = bankService.openAccount(Set.of(clientMock), new BigDecimal("1300"));
        Account accountTo = bankService.openAccount(Set.of(clientMockTwo), new BigDecimal("100"));

        bankService.transfer(accountFrom.getAccountId(),accountTo.getAccountId(), new BigDecimal("200"));
        assertEquals(new BigDecimal("1100"),accountFrom.getBalance());
        assertEquals(new BigDecimal("300"),accountTo.getBalance());
    }

    @Test
    void transfer_shouldThrowAnException_whenAccountIdIsWrong() {
        Account accountFrom = bankService.openAccount(Set.of(clientMock), new BigDecimal("1300"));
        Account accountTo = bankService.openAccount(Set.of(clientMockTwo), new BigDecimal("100"));

        assertThrows(NoSuchElementException.class, () -> {
            bankService.transfer(accountFrom.getAccountId(), "!123", new BigDecimal("300"));
        }, "To account not found");

        assertThrows(NoSuchElementException.class, () -> {
            bankService.transfer("123", accountTo.getAccountId(), new BigDecimal("300"));
        }, "From account not found");
    }

    @Test
    void splitAccounts_shouldSplitAccountsIntoClients_andHaveTheSameBalance() {
        Account account =  bankService.openAccount(Set.of(clientMock, clientMockTwo, clientMockThree), new BigDecimal("3"));
        Set<Account> spittedAccounts =  bankService.splitAccounts(account.getAccountId());

        assertEquals(3,spittedAccounts.size());
        spittedAccounts.forEach(acc->{
            assertEquals(new BigDecimal("1.00"),acc.getBalance());
        });

        Account accountTwo = bankService.openAccount(Set.of(clientMock, clientMockTwo), new BigDecimal("3"));
        Set<Account> spittedAccountsTwo =  bankService.splitAccounts(accountTwo.getAccountId());
        assertEquals(2,spittedAccountsTwo.size());
        spittedAccountsTwo.forEach(acc->{
            assertEquals(new BigDecimal("1.50"),acc.getBalance());
        });
        assertEquals(new BigDecimal("0.00"),accountTwo.getBalance());

        Account accountThree = bankService.openAccount(Set.of(clientMock, clientMockTwo), new BigDecimal("0.3"));
        Set<Account> spittedAccountsThree =  bankService.splitAccounts(accountThree.getAccountId());
        assertEquals(2,spittedAccountsThree.size());
        spittedAccountsThree.forEach(acc->{
            assertEquals(new BigDecimal("0.15"),acc.getBalance());
        });
        assertEquals(new BigDecimal("0.00"),accountThree.getBalance());

        Account accountFour = bankService.openAccount(Set.of(clientMock, clientMockTwo), new BigDecimal("0.03"));
        Set<Account> spittedAccountsFour =  bankService.splitAccounts(accountFour.getAccountId());
        assertEquals(2,spittedAccountsFour.size());
        spittedAccountsFour.forEach(acc->{
            assertEquals(new BigDecimal("0.01"),acc.getBalance());
        });
        assertEquals(new BigDecimal("0.01"),accountFour.getBalance());

    }

    @Test
    void applyInterestToAllAccounts_shouldApplyInterest () {
        Account account =  bankService.openAccount(Set.of(clientMock), new BigDecimal("100.00"));
        Account accountTwo = bankService.openAccount(Set.of(clientMockTwo), new BigDecimal("200.00"));

        bankService.applyInterestToAllAccounts(new BigDecimal("5"));
        assertEquals(new BigDecimal("105.00"),account.getBalance());
        assertEquals(new BigDecimal("210.00"),accountTwo.getBalance());

        Account accountThree =  bankService.openAccount(Set.of(clientMock), new BigDecimal("100.00"));
        bankService.applyInterestToAllAccounts(new BigDecimal("0.5"));
        assertEquals(new BigDecimal("100.50"),accountThree.getBalance());
    }
}
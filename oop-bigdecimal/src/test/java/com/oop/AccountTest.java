package com.oop;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Set;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {
    Client clientMock = new Client(UUID.randomUUID().toString(),"tim","macrae");

    @Test
    void deposit_shouldDepositTheAmount() {
        Account account = new Account(UUID.randomUUID().toString(), new BigDecimal("5"), Set.of(clientMock));
        account.deposit(new BigDecimal("5"));
        assertEquals(new BigDecimal("10"), account.getBalance());

        account.deposit(new BigDecimal("0.1"));
        assertEquals(new BigDecimal("10.1"), account.getBalance());

        account.deposit(new BigDecimal("0.2"));
        assertEquals(new BigDecimal("10.3"), account.getBalance());
    }

    @Test
    void withdraw_shouldWithdrawTheAmount() {
        Account account = new Account(UUID.randomUUID().toString(), new BigDecimal("5"), Set.of(clientMock));
        account.withdraw(new BigDecimal("0.1"));
        assertEquals(new BigDecimal("4.9"), account.getBalance());

        account.withdraw(new BigDecimal("1"));
        assertEquals(new BigDecimal("3.9"), account.getBalance());

        account.withdraw(new BigDecimal("4"));
        assertEquals(new BigDecimal("-0.1"), account.getBalance());

    }

    @Test
    void getAccountId() {
        String accId = UUID.randomUUID().toString();
        Account account = new Account(accId, new BigDecimal("5"), Set.of(clientMock));
        assertEquals(accId, account.getAccountId());
    }

    @Test
    void getBalance() {
        Account account = new Account(UUID.randomUUID().toString(), new BigDecimal("5"), Set.of(clientMock));
        assertEquals(new BigDecimal("5"), account.getBalance());
    }

    @Test
    void getClients() {
        Account account = new Account(UUID.randomUUID().toString(), new BigDecimal("5"), Set.of(clientMock));
        assertEquals(Set.of(clientMock), account.getClients());
    }

    @Test
    void addClient() {
        Account account = new Account(UUID.randomUUID().toString(), new BigDecimal("5"), Set.of(clientMock));
        account.addClient(clientMock);
        assertEquals(Set.of(clientMock), account.getClients());
        assertEquals(1, account.getClients().size());

    }

    @Test
    void getClient() {
        Account account = new Account(UUID.randomUUID().toString(), new BigDecimal("5"), Set.of(clientMock));
        assertEquals(clientMock, account.getClient(clientMock.customerId()));
    }
}
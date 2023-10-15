package com.walletservice.app;

import com.walletservice.model.*;
import com.walletservice.service.TransactionService;
import com.walletservice.service.TransactionServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TransactionServiceImplTest {

    private TransactionService transactionService;
    private Player testPlayer;

    @BeforeEach
    public void setUp() {
        transactionService = new TransactionServiceImpl();
        testPlayer = new Player("testUser", "password");
        testPlayer.setBalance(100.0);
    }

    @Test
    public void testDebitWithSufficientFunds() {
        boolean result = transactionService.debit(testPlayer, 50.0);
        assertTrue(result);
        assertEquals(50.0, testPlayer.getBalance());
    }

    @Test
    public void testDebitWithInsufficientFunds() {
        boolean result = transactionService.debit(testPlayer, 150.0);
        assertFalse(result);
        assertEquals(100.0, testPlayer.getBalance());
    }

    @Test
    public void testCredit() {
        transactionService.credit(testPlayer, 50.0);
        assertEquals(150.0, testPlayer.getBalance());
    }

    // ƒополнительные тесты дл€ других методов ...
}

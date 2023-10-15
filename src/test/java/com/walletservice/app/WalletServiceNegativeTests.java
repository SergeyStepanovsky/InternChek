package com.walletservice.app;

import com.walletservice.model.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.walletservice.service.TransactionServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class WalletServiceNegativeTests {

    @InjectMocks
    private TransactionServiceImpl transactionService;

    @Mock
    private Player player;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    // Тестирование попытки списать сумму, превышающую текущий баланс игрока
    @Test
    public void testDebitExceedsBalance() {
        when(player.getBalance()).thenReturn(50.0); // Устанавливаем текущий баланс игрока
        boolean result = transactionService.debit(player, 100.0); // Пытаемся списать сумму больше текущего баланса
        assertFalse(result); // Ожидаем, что результат будет false
        verify(player, times(0)).setBalance(anyDouble()); // Убеждаемся, что setBalance не был вызван
    }

    // Тестирование попытки добавления отрицательного значения на счет
    @Test
    public void testCreditNegativeValue() {
        assertThrows(IllegalArgumentException.class, () -> {
            transactionService.credit(player, -10.0);
        });
    }

    // Проверка возвращения пустой истории транзакций для несуществующего пользователя
    @Test
    public void testGetTransactionHistoryForNonExistentUser() {
        assertTrue(transactionService.getTransactionHistory("nonexistentUser").isEmpty());
    }

    // Проверка обработки нулевого игрока при попытке дебета
    @Test
    public void testDebitNullPlayer() {
        assertThrows(NullPointerException.class, () -> {
            transactionService.debit(null, 10.0);
        });
    }

    // Проверка обработки нулевого игрока при попытке кредита
    @Test
    public void testCreditNullPlayer() {
        assertThrows(NullPointerException.class, () -> {
            transactionService.credit(null, 10.0);
        });
    }
}

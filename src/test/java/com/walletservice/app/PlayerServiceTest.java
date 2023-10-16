package com.walletservice.app;

import static org.junit.jupiter.api.Assertions.*;

import com.walletservice.service.PlayerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PlayerServiceTest {

    private PlayerService playerService;

    @BeforeEach
    public void setUp() {
        playerService = new PlayerService();
    }

    @Test
    public void testRegister_NewPlayer_Success() {
        assertTrue(playerService.register("testUser", "testPass"));
    }

    @Test
    public void testRegister_ExistingPlayer_Failure() {
        playerService.register("testUser", "testPass");
        assertFalse(playerService.register("testUser", "testPass"));
    }
}

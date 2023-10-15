package com.walletservice.repository;

import com.walletservice.model.Player;

public interface PlayerRepository {
    Player findByUsername(String username);
    void save(Player player);
}

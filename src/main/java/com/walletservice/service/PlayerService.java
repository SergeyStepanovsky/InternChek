package com.walletservice.service;

import com.walletservice.model.Player;
import java.util.HashMap;
import java.util.Map;

/**
 * —ервис дл€ управлени€ данными игроков.
 * ѕозвол€ет регистрировать новых игроков, аутентифицировать существующих игроков и получать баланс игрока.
 */
public class PlayerService {

    /**
     * —ловарь, хран€щий всех зарегистрированных игроков по их именам пользовател€.
     */
    private Map<String, Player> players = new HashMap<>();

    /**
     * –егистрирует нового игрока в системе.
     *
     * @param username им€ пользовател€ дл€ регистрации.
     * @param password пароль пользовател€ дл€ регистрации.
     * @return true если регистраци€ успешна, false если им€ пользовател€ уже существует.
     */
    public boolean register(String username, String password) {
        if (players.containsKey(username)) {
            return false;
        }
        players.put(username, new Player(username, password));
        return true;
    }

    /**
     * ѕровер€ет учетные данные и возвращает объект игрока при успешной аутентификации.
     *
     * @param username им€ пользовател€ дл€ входа.
     * @param password пароль пользовател€ дл€ входа.
     * @return объект Player при успешном входе, null при неудаче.
     */
    public Player login(String username, String password) {
        Player player = players.get(username);
        if (player != null && player.getPassword().equals(password)) {
            return player;
        }
        return null;
    }
}
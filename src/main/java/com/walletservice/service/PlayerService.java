package com.walletservice.service;

import com.walletservice.model.Player;
import java.util.HashMap;
import java.util.Map;

/**
 * ������ ��� ���������� ������� �������.
 * ��������� �������������� ����� �������, ����������������� ������������ ������� � �������� ������ ������.
 */
public class PlayerService {

    /**
     * �������, �������� ���� ������������������ ������� �� �� ������ ������������.
     */
    private Map<String, Player> players = new HashMap<>();

    /**
     * ������������ ������ ������ � �������.
     *
     * @param username ��� ������������ ��� �����������.
     * @param password ������ ������������ ��� �����������.
     * @return true ���� ����������� �������, false ���� ��� ������������ ��� ����������.
     */
    public boolean register(String username, String password) {
        if (players.containsKey(username)) {
            return false;
        }
        players.put(username, new Player(username, password));
        return true;
    }

    /**
     * ��������� ������� ������ � ���������� ������ ������ ��� �������� ��������������.
     *
     * @param username ��� ������������ ��� �����.
     * @param password ������ ������������ ��� �����.
     * @return ������ Player ��� �������� �����, null ��� �������.
     */
    public Player login(String username, String password) {
        Player player = players.get(username);
        if (player != null && player.getPassword().equals(password)) {
            return player;
        }
        return null;
    }
}
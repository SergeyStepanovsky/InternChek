package com.walletservice.repository;

import com.walletservice.model.Player;

import java.util.Optional;

/**
 * ��������� {@code PlayerRepository} ������������ ����� ����������� ��� �������� ������� � ������ �������� {@link Player}.
 * ����������� ������������� ����������� ������ ��� ������ � ���������� �������.
 * ���������� ����� ���������� ����� �������� � ���� �������� � ������ ������, ��������� ��������� ��� ������� ����������� �������� ������.
 */
public interface PlayerRepository {

    /**
     * ������� � ���������� ������ {@link Player} �� ��������� ����� ������������.
     *
     * @param username ��� ������������, �� �������� ����������� �����.
     * @return ������ {@link Player} � �������� ������ ������������ ��� {@code null}, ���� ����� ����� �� ������.
     */
    Player findByUsername(String username);

    Optional<Player> findById(Integer id);

    /**
     * ��������� �������� ������ {@link Player} � �����������.
     * � ����������� �� ����������, ���� ����� ����� ��������� ���������� ������ ������ ��� ���������� �������������.
     *
     * @param player ������ {@link Player}, ������� ���������� ���������.
     */
    void save(Player player);
}

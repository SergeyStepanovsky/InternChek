package com.walletservice.repository;

import com.walletservice.model.Player;

import java.util.Optional;

/**
 * Интерфейс {@code PlayerRepository} представляет собой репозиторий для операций доступа к данным объектов {@link Player}.
 * Репозиторий предоставляет абстрактные методы для поиска и сохранения игроков.
 * Реализация этого интерфейса может включать в себя операции с базами данных, файловыми системами или другими источниками хранения данных.
 */
public interface PlayerRepository {

    /**
     * Находит и возвращает объект {@link Player} по заданному имени пользователя.
     *
     * @param username Имя пользователя, по которому выполняется поиск.
     * @return Объект {@link Player} с заданным именем пользователя или {@code null}, если такой игрок не найден.
     */
    Player findByUsername(String username);

    Optional<Player> findById(Integer id);

    /**
     * Сохраняет заданный объект {@link Player} в репозиторий.
     * В зависимости от реализации, этот метод может выполнять добавление нового игрока или обновление существующего.
     *
     * @param player Объект {@link Player}, который необходимо сохранить.
     */
    void save(Player player);
}

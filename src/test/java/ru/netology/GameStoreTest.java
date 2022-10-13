package ru.netology;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameStoreTest {

    @Test
    public void shouldAddGame() {

        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");


        assertTrue(store.containsGame(game));
    }

    @Test
    public void shouldAddPlayerWhichGamesMoreTime() {
        GameStore store = new GameStore();
        store.addPlayTime("Player 1", 10);
        store.addPlayTime("Player 2", 15);
        store.addPlayTime("Player 3", 22);

        String[] expected = {"Player 3"};
        String[] actual = store.getMostPlayer();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldSumTimeOnePlayer() {  // суммирует ли время проведенное за игрой одного игрока
        GameStore store = new GameStore();
        store.addPlayTime("Player 1", 7);
        store.addPlayTime("Player 1", 3);
        store.addPlayTime("Player 2", 8);

        String[] expected = {"Player 1"};
        String[] actual = store.getMostPlayer();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShowTheBestPlayerIfThereIsMoreThanOne() {
        GameStore store = new GameStore();
        store.addPlayTime("Player 1", 10);
        store.addPlayTime("Player 2", 10);
        store.addPlayTime("Player 3", 5);
        store.addPlayTime("Player 4", 10);

        String[] expected = {"Player 1", "Player 2", "Player 4"};
        String[] actual = store.getMostPlayer();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSumUpTheTimeOfAllPlayers() {
        GameStore store = new GameStore();
        store.addPlayTime("Player 1", 5);
        store.addPlayTime("Player 2", 1);
        store.addPlayTime("Player 3", 4);

        int expected = 10;
        int actual = store.getSumPlayedTime();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSumPlayerTime() {  //если играет один игрок
        GameStore store = new GameStore();
        store.addPlayTime("Player 1", 5);
        store.addPlayTime("Player 1", 2);
        store.addPlayTime("Player 1", 1);

        int expected = 8;
        int actual = store.getSumPlayedTime();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldShowBestPlayerIfPlayedOneHour() {   // если игрок играл 1 час
        GameStore store = new GameStore();
        store.addPlayTime("Player 1", 1);

        String[] expected = {"Player 1"};
        String[] actual = store.getMostPlayer();

        Assertions.assertArrayEquals(expected, actual);
    }
}

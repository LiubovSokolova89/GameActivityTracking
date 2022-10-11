package ru.netology;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PlayerTest {

    @Test
    public void shouldSumGenreIfOneGame() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Player player = new Player("Petya");
        player.installGame(game);
        player.play(game, 3);

        int expected = 3;
        int actual = player.sumGenre(game.getGenre());
        assertEquals(expected, actual);
    }

    @Test
    public void shouldGetMostPlayerByGenre(){
        GameStore store = new GameStore();
        Game game1 = store.publishGame("Cars", "Гонки");
        Game game2 = store.publishGame("Race", "Гонки");

        Player player = new Player("Bill");
        player.installGame(game1);
        player.installGame(game2);

        player.play(game1, 5);

        Game expected = null;
        Game actual = player.mostPlayerByGenre(game2.getGenre());

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldCalcIfSameGenreGames() {
        GameStore store = new GameStore();
        Game game1 = store.publishGame("Cars", "Гонки");
        Game game2 = store.publishGame("Race", "Гонки");

        Player player = new Player("Bill");
        player.installGame(game1);
        player.installGame(game2);
        player.play(game1, 5);
        player.play(game2, 10);

        int expected = 15;
        int actual = player.sumGenre("Гонки");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldCheckGamesIfThereAreExceptions() {
        GameStore store = new GameStore();
        Game game1 = store.publishGame("Cars", "Гонки");
        Game game2 = store.publishGame("Race", "Гонки");

        Player player = new Player("Bill");
        player.installGame(game1);
        player.play(game1, 15);

        Assertions.assertThrows(RuntimeException.class, () -> player.sumGenre("Гонки"));
    }

    // другие ваши тесты
}

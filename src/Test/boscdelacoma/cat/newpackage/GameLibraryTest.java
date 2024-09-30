package Test.boscdelacoma.cat.newpackage;

import Main.main.cat.boscdelacoma.newpackage.Game;
import Main.main.cat.boscdelacoma.newpackage.GameLibrary;
import Main.main.cat.boscdelacoma.newpackage.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

class GameLibraryTest {

    private GameLibrary library;

    @BeforeEach
    void setUp() {
        library = new GameLibrary();
        library.addGame(new Game("Return to Monkey Island", "Point and Click", "Windows", 22.99f));
        library.addGame(new Game("FIFA 23", "Sports", "PS5", 59.99f));
    }

    @Test
    void testAddGame() {
        Game newGame = new Game("Overwatch", "Shooter", "PlayStation", 39.99f);
        library.addGame(newGame);

        Game fetchedGame = library.findGame(new User("JaneDoe", "password"), "Overwatch");
        assertNotNull(fetchedGame);
        assertEquals("Overwatch", fetchedGame.getName());
    }

    @Test
    void testSearchByGenre() {
        List<Game> games = library.searchByGenre("Point and Click");

        assertEquals(1, games.size());
        assertEquals("Return to Monkey Island", games.get(0).getName());
    }

    @Test
    void testSearchByPlatform() {
        List<Game> games = library.searchByPlatform("PS5");

        assertEquals(1, games.size());
        assertEquals("FIFA 23", games.get(0).getName());
    }

    @Test
    void testSearchByPriceRange() {
        List<Game> games = library.searchByPriceRange(20f, 30f);

        assertEquals(1, games.size());
        assertEquals("Return to Monkey Island", games.get(0).getName());
    }

    @Test
    void testFindGame() {
        User user = new User("JohnDoe", "password");
        Game game = library.findGame(user, "FIFA 23");

        assertNotNull(game);
        assertEquals("FIFA 23", game.getName());
    }
}

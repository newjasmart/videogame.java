package Main.main.cat.boscdelacoma.newpackage;

import Main.main.cat.boscdelacoma.newpackage.Game;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameLibrary {
    private Map<String, Game> gameCollection;

    public GameLibrary() {
        this.gameCollection = new HashMap<>();
    }

    public void addGame(Game game) {
        gameCollection.put(game.getName(), game);
    }

    public Game findGame(User user, String gameName) {
        Game game = gameCollection.get(gameName);
        if (game != null) {
            game.addConsultingUser(user);
        }
        return game;
    }

    public List<Game> searchByGenre(String genre) {
        List<Game> results = new ArrayList<>();
        for (Game game : gameCollection.values()) {
            if (game.getGenre().equalsIgnoreCase(genre)) {
                results.add(game);
            }
        }
        return results;
    }

    public List<Game> searchByPlatform(String platform) {
        List<Game> results = new ArrayList<>();
        for (Game game : gameCollection.values()) {
            if (game.getPlatform().equalsIgnoreCase(platform)) {
                results.add(game);
            }
        }
        return results;
    }

    public List<Game> searchByPriceRange(float minPrice, float maxPrice) {
        List<Game> results = new ArrayList<>();
        for (Game game : gameCollection.values()) {
            if (game.getPrice() >= minPrice && game.getPrice() <= maxPrice) {
                results.add(game);
            }
        }
        return results;
    }
}

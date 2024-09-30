package Main.main.cat.boscdelacoma.newpackage;

import Main.main.cat.boscdelacoma.newpackage.GameLibrary;
import Main.main.cat.boscdelacoma.newpackage.Game;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        GameLibrary library = new GameLibrary();
        library.addGame(new Game("Return to Monkey Island", "Point and Click", "Windows", 22.99f));
        library.addGame(new Game("FIFA 23", "Sports", "PS5", 59.99f));
        library.addGame(new Game("Overwatch", "Shooter", "PlayStation", 39.99f));

        UserService userService = new UserService();
        Scanner scanner = new Scanner(System.in);

        // User Registration
        System.out.println("User Registration");
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();
        if (!userService.registerUser(username, password)) {
            System.out.println("Username is already taken.");
        }

        // User Login
        System.out.println("User Login");
        System.out.print("Username: ");
        String loginUsername = scanner.nextLine();
        System.out.print("Password: ");
        String loginPassword = scanner.nextLine();
        if (!userService.authenticate(loginUsername, loginPassword)) {
            System.out.println("Invalid credentials.");
            return;
        }
        User loggedInUser = new User(loginUsername, loginPassword);

        // Search games by category
        System.out.println("Search for games by category");
        System.out.print("Category: ");
        String category = scanner.nextLine();
        List<Game> gamesByCategory = library.searchByGenre(category);
        gamesByCategory.forEach(Game::displayInfo);

        // Search games by platform
        System.out.println("Search for games by platform");
        System.out.print("Platform: ");
        String platform = scanner.nextLine();
        List<Game> gamesByPlatform = library.searchByPlatform(platform);
        gamesByPlatform.forEach(Game::displayInfo);

        // Search games by price range
        System.out.println("Search for games by price");
        System.out.print("Minimum price: ");
        float minPrice = scanner.nextFloat();
        System.out.print("Maximum price: ");
        float maxPrice = scanner.nextFloat();
        List<Game> gamesByPrice = library.searchByPriceRange(minPrice, maxPrice);
        gamesByPrice.forEach(Game::displayInfo);

        scanner.nextLine(); // To clear buffer

        // Add game review
        System.out.println("Review a game");
        System.out.print("Game name: ");
        String gameName = scanner.nextLine();
        Game game = library.findGame(loggedInUser, gameName);
        if (game != null) {
            System.out.print("Comment: ");
            String comment = scanner.nextLine();
            System.out.print("Rating (1-5): ");
            int rating = scanner.nextInt();
            game.addReview(new Review(loggedInUser, comment, rating));
        }

        // Show users who have consulted a game
        System.out.println("\n** Users who have consulted 'Return to Monkey Island'");
        Game consultedGame = library.findGame(loggedInUser, "Return to Monkey Island");
        Set<User> consultedUsers = consultedGame.getConsultingUsers();
        consultedUsers.forEach(user -> System.out.println(user.getUsername()));

        // Show reviews for the game
        System.out.println("\n** Reviews for 'Return to Monkey Island'");
        List<Review> reviews = consultedGame.getReviews();
        reviews.forEach(review -> System.out.println(review.getUser().getUsername() + ": " + review.getComment() + " (Rating: " + review.getRating() + ")"));
    }
}

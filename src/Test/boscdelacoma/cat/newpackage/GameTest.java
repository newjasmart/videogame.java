package Test.boscdelacoma.cat.newpackage;

import Main.main.cat.boscdelacoma.newpackage.Game;
import Main.main.cat.boscdelacoma.newpackage.Review;
import Main.main.cat.boscdelacoma.newpackage.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Set;

class GameTest {

    private Game game;
    private User user;

    @BeforeEach
    void setUp() {
        game = new Game("Return to Monkey Island", "Point and Click", "Windows", 22.99f);
        user = new User("JohnDoe", "password");
    }

    @Test
    void testGetName() {
        assertEquals("Return to Monkey Island", game.getName());
    }

    @Test
    void testAddConsultingUser() {
        game.addConsultingUser(user);
        Set<User> consultingUsers = game.getConsultingUsers();
        assertTrue(consultingUsers.contains(user));
    }

    @Test
    void testGetConsultingUsers() {
        game.addConsultingUser(user);
        Set<User> users = game.getConsultingUsers();
        assertEquals(1, users.size());
        assertTrue(users.contains(user));
    }

    @Test
    void testAddReview() {
        Review review = new Review(user, "Amazing game!", 5);
        game.addReview(review);
        List<Review> reviews = game.getReviews();
        assertEquals(1, reviews.size());
        assertEquals(review, reviews.get(0));
    }

    @Test
    void testGetReviews() {
        Review review1 = new Review(user, "Great game", 4);
        Review review2 = new Review(new User("JaneDoe", "password123"), "Not bad", 3);
        game.addReview(review1);
        game.addReview(review2);
        
        List<Review> reviews = game.getReviews();
        assertEquals(2, reviews.size());
        assertEquals("Great game", reviews.get(0).getComment());
        assertEquals(4, reviews.get(0).getRating());
        assertEquals("Not bad", reviews.get(1).getComment());
        assertEquals(3, reviews.get(1).getRating());
    }
}

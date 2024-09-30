package Test.boscdelacoma.cat.newpackage;

import Main.main.cat.boscdelacoma.newpackage.Review;
import Main.main.cat.boscdelacoma.newpackage.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReviewTest {

    private Review review;
    private User user;

    @BeforeEach
    void setUp() {
        user = new User("JohnDoe", "password");
        review = new Review(user, "Great game", 5);
    }

    @Test
    void testGetUser() {
        assertEquals(user, review.getUser());
    }

    @Test
    void testGetComment() {
        assertEquals("Great game", review.getComment());
    }

    @Test
    void testGetRating() {
        assertEquals(5, review.getRating());
    }

    @Test
    void testSetRating() {
        review = new Review(user, "Good game", 3);
        assertEquals(3, review.getRating());
    }
}

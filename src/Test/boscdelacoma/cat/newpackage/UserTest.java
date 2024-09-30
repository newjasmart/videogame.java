package Test.boscdelacoma.cat.newpackage;

import Main.main.cat.boscdelacoma.newpackage.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    private User user;

    @BeforeEach
    void setUp() {
        user = new User("JohnDoe", "password");
    }

    @Test
    void testGetUsername() {
        assertEquals("JohnDoe", user.getUsername());
    }

    @Test
    void testLoginSuccess() {
        assertTrue(user.login("password"));
    }

    @Test
    void testLoginFailure() {
        assertFalse(user.login("wrongpassword"));
    }
}

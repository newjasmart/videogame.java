package Test.boscdelacoma.cat.newpackage;

import Main.main.cat.boscdelacoma.newpackage.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

    private UserService userService;

    @BeforeEach
    void setUp() {
        userService = new UserService();
        userService.registerUser("JaneDoe", "password123");
    }

    @Test
    void testUserRegistration() {
        assertFalse(userService.registerUser("JaneDoe", "password456"));
        assertTrue(userService.registerUser("JohnDoe", "password789"));
    }

    @Test
    void testAuthenticate() {
        assertTrue(userService.authenticate("JaneDoe", "password123"));
        assertFalse(userService.authenticate("JaneDoe", "wrongpassword"));
    }
}

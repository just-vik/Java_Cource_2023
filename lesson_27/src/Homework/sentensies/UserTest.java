package Homework.sentensies;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    private User user;

    @BeforeEach
    void setUp() {
        user = new User("ivan.ivanov@mail.com", "IvaNov23");
    }

    @Test
    void setEmail() {
        user.setEmail("ivan.ivanov@mail.com");
        assertEquals("ivan.ivanov@mail.com", user.getEmail());
    }

    @Test
    void setPassword() {
    }
}
package fr.esiea.ex4A.models;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    private final User u;

    UserTest() {
        this.u = new User(new User("test", "test@test.com", "test87", "M", "F", "FR"), 50);
    }

    @Test
    void getUsername() {
        assertEquals("test", this.u.getUsername());
    }

    @Test
    void getEmail() {
        assertEquals("test@test.com", this.u.getEmail());
    }

    @Test
    void getTwitter() {
        assertEquals("test87", this.u.getTwitter());
    }

    @Test
    void getAge() {
        assertEquals(50, this.u.getAge());
    }

    @Test
    void getCountry() {
        assertEquals("FR", this.u.getCountry());
    }
}

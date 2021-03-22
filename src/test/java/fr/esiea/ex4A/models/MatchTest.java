package fr.esiea.ex4A.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatchTest {

    private final Match m;

    MatchTest() {
        this.m = new Match(new User("test", "test@test.com", "test87", "M", "F", "FR"));
    }

    @Test
    void getUsername() {
        assertEquals("test", m.getUsername());
    }

    @Test
    void getTwitter() {
        assertEquals("test87", m.getTwitter());
    }
}

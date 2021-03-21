package fr.esiea.ex4A.repositories;

import fr.esiea.ex4A.models.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MeetRepository {

    private final List<User> users = new ArrayList<>();

    public List<User> getAllUsers() {
        return new ArrayList<User>(this.users);
    }
}

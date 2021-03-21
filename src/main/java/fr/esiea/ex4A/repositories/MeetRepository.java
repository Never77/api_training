/* (Copyrights Hector GODZIEN) 2021 */
package fr.esiea.ex4A.repositories;

import fr.esiea.ex4A.models.User;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class MeetRepository {

    private final List<User> users = new ArrayList<>();

    public List<User> getAllUsers() {
        return new ArrayList<User>(this.users);
    }
    public void addUser(User user) {
        this.users.add(user);
    }
}

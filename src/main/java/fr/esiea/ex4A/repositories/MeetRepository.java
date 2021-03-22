/* (Copyrights Hector GODZIEN) 2021 */
package fr.esiea.ex4A.repositories;

import fr.esiea.ex4A.models.User;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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

    public User getUserByNameAndCountry(String username, String country) {
        Optional<User> user =
                this.users.stream()
                        .filter(
                                x ->
                                        x.getUsername().equals(username)
                                                && x.getCountry().equals(country))
                        .findFirst();
        return user.isEmpty() ? null : user.get();
    }

    public void removeUser(User u) {
        this.users.remove(u);
    }
}

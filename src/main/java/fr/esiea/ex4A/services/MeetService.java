/* (Copyrights Hector GODZIEN) 2021 */
package fr.esiea.ex4A.services;

import fr.esiea.ex4A.models.User;
import fr.esiea.ex4A.repositories.MeetRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;

@Service
public class MeetService {

    @Autowired private final MeetRepository repository;

    public MeetService(MeetRepository repository) {
        this.repository = repository;
    }

    public List<User> getAllUsers() {
        return this.repository.getAllUsers();
    }

    public void addUser(User user) {
        this.repository.addUser(user);
    }

    public User getUserByNameAndCountry(String username, String country) {
        return this.repository.getUserByNameAndCountry(username, country);
    }

    public Boolean match(@NotNull User u, @NotNull User v) {
        return Math.abs(u.getAge() - v.getAge()) <= 4 && u.getSex() == v.getSexPref() && v.getSex() == u.getSexPref();
    }

    public void removeUser(User u) {
        this.repository.removeUser(u);
    }
}

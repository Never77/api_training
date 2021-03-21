/* (Copyrights Hector GODZIEN) 2021 */
package fr.esiea.ex4A.services;

import fr.esiea.ex4A.models.User;
import fr.esiea.ex4A.repositories.MeetRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}

package fr.esiea.ex4A.services;

import fr.esiea.ex4A.models.User;
import fr.esiea.ex4A.repositories.MeetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeetService {

    @Autowired
    private final MeetRepository repository;

    public MeetService(MeetRepository repository) {
        this.repository = repository;
    }

    public List<User> getAllUsers() {
        return this.repository.getAllUsers();
    }
}

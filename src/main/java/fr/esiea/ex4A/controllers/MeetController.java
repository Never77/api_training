package fr.esiea.ex4A.controllers;

import fr.esiea.ex4A.models.User;
import fr.esiea.ex4A.services.MeetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/api")
public class MeetController {

    @Autowired
    private final MeetService service;

    public MeetController(MeetService service) {
        this.service = service;
    }

    @GetMapping(path = "/users", produces = "application/json")
    public List<User> getAllUsers() {
        return this.service.getAllUsers();
    }

    @PostMapping(path = "/inscription", produces = "application/json")
    public ResponseEntity<?> signUp(@RequestBody User user) {
        return null;
    }

    @GetMapping(path = "/matches")
    public ResponseEntity<?> getMatches(@RequestParam(value = "userName") String username, @RequestParam(value = "userCountry") String country) {
        return null;
    }

}

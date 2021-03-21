/* (Copyrights Hector GODZIEN) 2021 */
package fr.esiea.ex4A.controllers;

import fr.esiea.ex4A.models.Match;
import fr.esiea.ex4A.models.User;
import fr.esiea.ex4A.services.MeetService;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/api")
public class MeetController {

    @Autowired private final MeetService service;

    public MeetController(MeetService service) { this.service = service; }

    @GetMapping(path = "/users", produces = "application/json")
    public ResponseEntity<List<User>> getAllUsers() {
        return new ResponseEntity<>(this.service.getAllUsers(), HttpStatus.OK);
    }

    @PostMapping(
            path = "/inscription",
            produces = "application/json",
            consumes = "application/json")
    public ResponseEntity<?> signUp(@Valid @RequestBody User user) {
        this.service.addUser(user);
        if (this.service.getAllUsers().contains(user)) {
            return new ResponseEntity<>(user, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(user, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping(path = "/matches", produces = "application/json")
    public ResponseEntity<?> getMatches(
            @NotNull @NotBlank @RequestParam(value = "userName") String username,
            @NotNull @NotBlank @RequestParam(value = "userCountry") String country) {
        return new ResponseEntity<>(new Match("jacklin", "@yourSweetHeart45"), HttpStatus.OK);
    }
}

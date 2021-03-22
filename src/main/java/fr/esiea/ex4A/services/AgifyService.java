/* (Copyrights Hector GODZIEN) 2021 */
package fr.esiea.ex4A.services;

import fr.esiea.ex4A.clients.AgifyClient;
import fr.esiea.ex4A.models.User;
import fr.esiea.ex4A.repositories.MeetRepository;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgifyService {

    @Autowired private final AgifyClient agifyClient;
    @Autowired private final MeetRepository meetRepository;

    public AgifyService(AgifyClient agifyClient, MeetRepository meetRepository) {
        this.agifyClient = agifyClient;
        this.meetRepository = meetRepository;
    }

    public Integer getAgeByNameAndCountry(String username, String country) {
        try {
            User u = this.meetRepository.getUserByNameAndCountry(username, country);
            if (u != null) {
                return u.getAge();
            }
            return Integer.parseInt(
                    agifyClient
                            .getAgeByNameAndCountry(username, country)
                            .execute()
                            .body()
                            .get("age"));
        } catch (IOException | NullPointerException e) {
            return null;
        }
    }
}

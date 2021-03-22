/* (Copyrights Hector GODZIEN) 2021 */
package fr.esiea.ex4A.services;

import fr.esiea.ex4A.clients.AgifyClient;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgifyService {

    @Autowired private final AgifyClient agifyClient;

    public AgifyService(AgifyClient agifyClient) {
        this.agifyClient = agifyClient;
    }

    public Integer getAgeByNameAndCountry(String username, String country) {
        try {
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

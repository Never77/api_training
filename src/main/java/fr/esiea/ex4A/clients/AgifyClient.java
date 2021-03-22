/* (Copyrights Hector GODZIEN) 2021 */
package fr.esiea.ex4A.clients;

import java.util.Map;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface AgifyClient {

    @GET(value = "/")
    Call<Map<String, String>> getAgeByNameAndCountry(
            @Query(value = "name") String name, @Query(value = "country_id") String country);
}

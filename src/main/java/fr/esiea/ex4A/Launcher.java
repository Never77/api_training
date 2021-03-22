package fr.esiea.ex4A;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import retrofit2.Retrofit;

@SpringBootApplication
public class Launcher {

    public static void main(String[] args) {
        SpringApplication.run(Launcher.class, args);
    }

    @Bean
    AgifyClient agifyClient() {
        Retrofit retrofit = Retrofit.Builder()
            .baseUrl("https://api.agify.io")
            .build();

        return retrofit.create(AgifyClient.class);
    }
}

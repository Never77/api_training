/* (Copyrights Hector GODZIEN) 2021 */
package fr.esiea.ex4A.controllers;

import fr.esiea.ex4A.models.User;
import fr.esiea.ex4A.repositories.MeetRepository;
import fr.esiea.ex4A.services.MeetService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
class MeetControllerIT {

    private final MockMvc mockMvc;

    @MockBean
    private MeetRepository repository;

    @MockBean
    private MeetService service;

    MeetControllerIT(@Autowired MockMvc mockMvc) { this.mockMvc = mockMvc; }

    @Test
    void getAllUsersTest() throws Exception {
        mockMvc
            .perform(MockMvcRequestBuilders.get("/api/users"))
            .andExpect(status().isOk())
            .andExpect(content().json(
    """
                []
                """));
    }

    @Test
    void signUpTest() throws Exception {
        User u = new User("machin", "machin@truc.com", "machin45", "M", "F", "FR");
        List<User> users = new ArrayList<>();
        doAnswer(invocation -> {
            User v = invocation.getArgument(0);
            repository.addUser(v);
            return null;
        }).when(service).addUser(any(User.class));
        doAnswer(invocation -> {
            User v = invocation.getArgument(0);
            users.add(v);
            return null;
        }).when(repository).addUser(any(User.class));
        mockMvc
            .perform(MockMvcRequestBuilders
                .post("/api/inscription")
                .contentType("application/json")
                .content(
                """
                    {
                        "userEmail": "machin@truc.com",
                        "userName": "machin",
                        "userTweeter": "machin45",
                        "userCountry": "FR",
                        "userSex": "M",
                        "userSexPref": "F"
                    }
                """))
            .andExpect(status().isCreated())
            .andExpect(content().json(
    """
                    {
                        "email": "machin@truc.com",
                        "username": "machin",
                        "twitter": "machin45",
                        "country": "FR",
                        "sex": "M",
                        "sexPref": "F"
                    }
                """));
        verify(service, times(1)).addUser(any(User.class));
        verify(repository, times(1)).addUser(any(User.class));
    }

    @Test
    void getMatchesTest() throws Exception{
        List<User> users = List.of(
            new User(new User("machin", "machin@truc.com", "machin45", "F", "M", "FR"), 52),
            new User(new User("test", "test@test.com", "test87", "M", "F", "FR"), 54)
        );

        doReturn(users).when(repository).getAllUsers();
        doReturn(users.get(1)).when(repository).getUserByNameAndCountry(anyString(), anyString());
        doReturn(repository.getUserByNameAndCountry("test", "FR")).when(service).getUserByNameAndCountry(anyString(), anyString());
        doReturn(repository.getAllUsers()).when(service).getAllUsers();
        doReturn(true).when(service).match(any(User.class), any(User.class));


        mockMvc
            .perform(
                MockMvcRequestBuilders.get("/api/matches?userName=test&userCountry=FR")
                .header("Accept", "application/json"))
            .andExpect(status().isOk());

        verify(service, times(1)).getAllUsers();
        verify(service, times(1)).getUserByNameAndCountry(anyString(), anyString());
    }

    @Test
    void getMatchesWhenUserNotRegisteredTest() throws Exception {
        mockMvc
            .perform(
                MockMvcRequestBuilders.get("/api/matches?userName=toto&userCountry=DE")
                .header("Accept", "application/json")
            )
            .andExpect(status().isOk())
            .andExpect(content().json(
        """
                    []
                    """
            ));
    }
}

package com.example.full_test.repository;

import com.example.full_test.dto.UserDto;
import com.example.full_test.model.User;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class UserRepositoryIntegrTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private UserRepository repository;

    private ObjectMapper mapper = new ObjectMapper();

    @BeforeEach
    public void beforeEach() {
        repository.deleteAll();
    }

    @Test
    public void getByIdTest() throws Exception {
        User user = User.builder()
                .login("Alesya")
                .password("pass")
                .build();

        User savedUser = repository.save(user);
        Long idOfSavedUser = savedUser.getId();

        ResultActions resultActions = mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/users/{id}", idOfSavedUser))
                .andDo(MockMvcResultHandlers.print());

        resultActions
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", CoreMatchers.is(idOfSavedUser.intValue())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.login", CoreMatchers.is("Alesya")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.password", CoreMatchers.is("pass")));

    }

    @Test
    public void saveTest() throws Exception {
        UserDto user = UserDto.builder()
                .login("Alesya")
                .build();

        ResultActions resultActions = mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/users")
                        .contentType("application/json")
                        .content(mapper.writeValueAsString(user)))
                .andDo(MockMvcResultHandlers.print());

        resultActions
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.login", CoreMatchers.is("Alesya")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.password", CoreMatchers.is("default")));

    }

    @Test
    public void saveNotUniqueTest() throws Exception {
        UserDto user = UserDto.builder()
                .login("Alesya")
                .build();

        repository.save(new User("Alesya",null));

        ResultActions resultActions = mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/users")
                        .contentType("application/json")
                        .content(mapper.writeValueAsString(user)))
                .andDo(MockMvcResultHandlers.print());

        resultActions
                .andExpect(MockMvcResultMatchers.status().is4xxClientError());

    }

}

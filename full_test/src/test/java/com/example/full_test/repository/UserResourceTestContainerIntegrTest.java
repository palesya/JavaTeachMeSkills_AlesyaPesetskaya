package com.example.full_test.repository;

import com.example.full_test.model.User;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Testcontainers
public class UserResourceTestContainerIntegrTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private UserRepository repository;

    @DynamicPropertySource
    public static void initProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url",postgreSQLContainer::getJdbcUrl);
        registry.add("spring.datasource.username",postgreSQLContainer::getUsername);
        registry.add("spring.datasource.password",postgreSQLContainer::getPassword);
    }

    @Container
    public static PostgreSQLContainer postgreSQLContainer = new PostgreSQLContainer("postgres:13.8")
            .withDatabaseName("test")
            .withUsername("admin")
            .withPassword("admin");

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
}

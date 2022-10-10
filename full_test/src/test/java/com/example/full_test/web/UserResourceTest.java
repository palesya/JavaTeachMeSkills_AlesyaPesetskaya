package com.example.full_test.web;

import com.example.full_test.dto.UserDto;
import com.example.full_test.model.User;
import com.example.full_test.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(UserResource.class)
class UserResourceTest {

    @MockBean
    private UserService service;
    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper mapper = new ObjectMapper();

    @Test
    void getById() throws Exception {
        UserDto userResponse = UserDto.builder()
                .id(10L)
                .login("Alesya")
                .password("pass")
                .build();

        Mockito.when(service.getById(10L)).thenReturn(userResponse);

        ResultActions perform = mockMvc.perform(MockMvcRequestBuilders.get("/users/{id}", "10"))
                .andDo(MockMvcResultHandlers.print());

        perform.andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers
                        .jsonPath("$.id", CoreMatchers.is(10)))
                .andExpect(MockMvcResultMatchers
                        .jsonPath("$.login", CoreMatchers.is("Alesya")))
                .andExpect(MockMvcResultMatchers
                        .jsonPath("$.password", CoreMatchers.is("pass")));

        String contentAsString = perform.andReturn().getResponse().getContentAsString();
        User user = mapper.readValue(contentAsString, User.class);
        Assertions.assertEquals(user.getId(), 10);
        Assertions.assertEquals(user.getLogin(), "Alesya");
        Assertions.assertEquals(user.getPassword(), "pass");
    }

    @Test
    void getByIdNotFound() throws Exception {

        Mockito.when(service.getById(10L)).thenReturn(null);

        ResultActions perform = mockMvc
                .perform(MockMvcRequestBuilders.get("/users/{id}", "10"))
                .andDo(MockMvcResultHandlers.print());

        perform.andExpect(MockMvcResultMatchers.status().is(400));
    }

    @Test
    void saveUser() throws Exception {
        UserDto user = UserDto.builder()
                .login("Alesya")
                .build();

        UserDto userResponse = UserDto.builder()
                .id(10L)
                .login("Alesya")
                .build();

        Mockito.when(service.save(user)).thenReturn(userResponse);

        ResultActions response = mockMvc
                .perform(MockMvcRequestBuilders.post("/users")
                        .contentType("application/json")
                        .content(mapper.writeValueAsString(user)))
                .andDo(MockMvcResultHandlers.print());

        response.andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers
                        .jsonPath("$.id", CoreMatchers.is(10)));

    }
}
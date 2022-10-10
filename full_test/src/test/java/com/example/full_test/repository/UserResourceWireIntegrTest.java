package com.example.full_test.repository;

import com.example.full_test.dto.UserDto;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import com.github.tomakehurst.wiremock.junit5.WireMockExtension;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;
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
public class UserResourceWireIntegrTest {

    @Autowired
    private MockMvc mockMvc;
    private ObjectMapper mapper = new ObjectMapper();

    @RegisterExtension
    static WireMockExtension WIREMOCKEXT = WireMockExtension.newInstance()
            .options(WireMockConfiguration.options().port(8099))
            .build();

    @Test
    public void saveTest() throws Exception {
        UserDto user = UserDto.builder()
                .login("testForWireMock")
                .build();


        String jsonUser = mapper.writeValueAsString(user);

        WIREMOCKEXT.stubFor(WireMock.get("/user")
                .willReturn(WireMock.ok(jsonUser)
                        .withHeader("Content-Type", "application/json")));

        ResultActions resultActions = mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/users/test")
                        .contentType("application/json")
                        .content(mapper.writeValueAsString(new UserDto())))
                .andDo(MockMvcResultHandlers.print());

        resultActions
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.login", CoreMatchers.is("testForWireMock")));

    }
}

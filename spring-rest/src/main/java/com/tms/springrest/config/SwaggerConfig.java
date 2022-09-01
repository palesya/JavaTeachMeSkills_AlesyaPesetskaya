package com.tms.springrest.config;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    GroupedOpenApi userSwaggerController(){
        return GroupedOpenApi
                .builder()
                .group("My user controller")
                .pathsToMatch("/api/**")
                .build();
    }

    @Bean
    GroupedOpenApi actuatorSwaggerController(){
        return GroupedOpenApi
                .builder()
                .group("My actuator controller")
                .pathsToMatch("/actuator/**")
                .build();
    }
}

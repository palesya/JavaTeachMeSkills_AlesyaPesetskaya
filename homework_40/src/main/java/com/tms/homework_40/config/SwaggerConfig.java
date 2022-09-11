package com.tms.homework_40.config;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    GroupedOpenApi catSwaggerController(){
        return GroupedOpenApi
                .builder()
                .group("Cat controller")
                .pathsToMatch("/api/**")
                .build();
    }

    @Bean
    GroupedOpenApi actuatorSwaggerController(){
        return GroupedOpenApi
                .builder()
                .group("Actuator controller")
                .pathsToMatch("/actuator/**")
                .build();
    }

}

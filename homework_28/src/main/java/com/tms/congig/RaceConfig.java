package com.tms.congig;


import com.tms.model.Horse;
import com.tms.model.Pair;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RaceConfig {

    @Bean
    public Horse horse1(@Value("Snow white") String name) {
        return new Horse(name);
    }

    @Bean
    public Horse horse2() {

    }

    @Bean
    public Horse horse3() {

    }

    @Bean
    public Horse rider1(@Value("Pavel") String name) {

    }

    @Bean
    public Horse rider2() {

    }

    @Bean
    public Horse rider3() {

    }

    @Bean
    public Pair pair1() {

    }

    @Bean
    public Pair pair2() {

    }

    @Bean
    public Pair pair3() {

    }

}

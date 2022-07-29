package com.tms.congig;


import com.tms.model.Horse;
import com.tms.model.Pair;
import com.tms.model.Rider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RaceConfig {

    @Bean
    public Horse horse1(){
        return new Horse("Snow White");
    }

    @Bean
    public Horse horse2(){
        return new Horse("Black Jack");
    }

    @Bean
    public Horse horse3(){
        return new Horse("Pirate");
    }

    @Bean
    public Rider rider1(){
        return new Rider("Alesya");
    }

    @Bean
    public Rider rider2(){
        return new Rider("Pavel");
    }

    @Bean
    public Rider rider3(){
        return new Rider("Sofiya");
    }

    @Bean
    public Pair pair1() {
        return new Pair(horse1(),rider1());
    }

    @Bean
    public Pair pair2() {
        return new Pair(horse2(),rider2());
    }

    @Bean
    public Pair pair3() {
        return new Pair(horse3(),rider3());
    }

}

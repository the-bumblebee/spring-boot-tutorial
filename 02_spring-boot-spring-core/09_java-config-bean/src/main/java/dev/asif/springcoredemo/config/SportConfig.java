package dev.asif.springcoredemo.config;

import dev.asif.springcoredemo.common.Coach;
import dev.asif.springcoredemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

    // Manually creating and configuring a bean
    // Bean id here is the method name - "swimCoach"
    @Bean
    public Coach swimCoach() {
        return new SwimCoach();
    }

}

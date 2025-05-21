package pl.gatomek.manyportsapp.random.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RandomNumberServiceConfig {

    @Bean
    RandomNumberService randomNumberService() {
        return new RandomNumberService();
    }
}

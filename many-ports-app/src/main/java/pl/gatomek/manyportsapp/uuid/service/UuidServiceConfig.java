package pl.gatomek.manyportsapp.uuid.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UuidServiceConfig {
    @Bean
    public UuidService uuidService() {
        return new UuidService();
    }
}

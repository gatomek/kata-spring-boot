package pl.gatomek.manyportsapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.gatomek.manyportsapp.random.usecase.GenerateRandomNumberUseCase;
import pl.gatomek.manyportsapp.random.usecase.RandomNumberService;
import pl.gatomek.manyportsapp.uuid.usecase.GenerateUuidUseCase;
import pl.gatomek.manyportsapp.uuid.usecase.UuidService;

@Configuration
public class ServiceConfig {

    @Bean
    public GenerateUuidUseCase uuidService() {
        return new UuidService();
    }

    @Bean
    public GenerateRandomNumberUseCase randomNumberService() {
        return new RandomNumberService();
    }
}

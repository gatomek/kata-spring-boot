package pl.gatomek.manyportsapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.gatomek.manyportsapp.filter.InternalApiFilter;

@Configuration
class AppConfig {

    @Bean
    public InternalApiFilter internalApiFilter(CustomConfig customConfig) {
        return new InternalApiFilter(customConfig);
    }
}
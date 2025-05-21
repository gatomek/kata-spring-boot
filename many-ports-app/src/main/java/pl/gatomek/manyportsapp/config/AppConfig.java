package pl.gatomek.manyportsapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.gatomek.manyportsapp.filter.InternalApiFilter;

@Configuration
public class AppConfig {

    @Bean
    public InternalApiFilter internalApiFilter() {
        return new InternalApiFilter();
    }
}
package pl.gatomek.manyportsapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(
        basePackages = {
                "pl.gatomek.manyportsapp.config",
                "pl.gatomek.manyportsapp.random.rest",
                "pl.gatomek.manyportsapp.uuid.rest"
        })
@EnableAutoConfiguration
@SpringBootConfiguration

public class ManyPortsAppApplication {
    public static void main(String[] args) {
        SpringApplication.run(ManyPortsAppApplication.class, args);
    }
}


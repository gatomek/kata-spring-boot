package pl.gatomek.manyportsapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(
        basePackages = {
                "pl.gatomek.manyportsapp.random.service",
                "pl.gatomek.manyportsapp.random.rest",
                "pl.gatomek.manyportsapp.uuid.service",
                "pl.gatomek.manyportsapp.uuid.rest",
                "pl.gatomek.manyportsapp.config"
        })
@EnableAutoConfiguration
@SpringBootConfiguration

public class ManyPortsApplication {
    public static void main(String[] args) {
        SpringApplication.run(ManyPortsApplication.class, args);
    }
}


package pl.gatomek.thymeleafthermometersse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ThymeleafThermometerSseApplication {

    public static void main(String[] args) {
        SpringApplication.run(ThymeleafThermometerSseApplication.class, args);
    }

}

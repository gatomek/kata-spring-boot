package pl.gatomek.amqp.runner;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.gatomek.amqp.model.UuidMessage;
import pl.gatomek.amqp.service.ProducerRabbitService;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class Runner implements CommandLineRunner {

    private final ProducerRabbitService producerRabbitService;

    @Override
    public void run(String... args) {
        producerRabbitService.send(new UuidMessage(UUID.randomUUID()));
    }
}

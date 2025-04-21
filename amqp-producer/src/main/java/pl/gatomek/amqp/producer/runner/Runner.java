package pl.gatomek.amqp.producer.runner;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.gatomek.amqp.producer.service.ProducerRabbitService;
import pl.gatomek.amqp.common.model.UuidMessage;

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

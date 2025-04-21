package pl.gatomek.amqp.consumer.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import pl.gatomek.amqp.common.model.UuidMessage;

@Component
@Slf4j
public class AmqpConsumer {

    @RabbitListener(queues = "${rabbitmq.queue-name}")
    public void processUuidMessage(UuidMessage uuidMessage) {
        log.info("Message received: {}", uuidMessage);
    }
}

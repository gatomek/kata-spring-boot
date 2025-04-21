package pl.gatomek.amqp.producer.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import pl.gatomek.amqp.producer.properties.RabbitProperties;
import pl.gatomek.amqp.common.model.UuidMessage;

@RequiredArgsConstructor
@Service
@Slf4j
public class ProducerRabbitService {
    private final RabbitTemplate rabbitTemplate;
    private final RabbitProperties rabbitProperties;

    public void send(UuidMessage msg) {
        try {
            rabbitTemplate.convertAndSend(rabbitProperties.getExchangeName(), rabbitProperties.getRoutingKey(), msg);
            log.info("Message sent: {}", msg);
        } catch (AmqpException ex) {
            log.error("Amqp Exception:", ex);
        }
    }
}

package pl.gatomek.amqp.producer.properties;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "rabbitmq")
@Getter
@Setter
public class RabbitProperties {
    @NotBlank
    private String queueName;

    @NotBlank
    private String exchangeName;

    @NotBlank
    private String routingKey;
}

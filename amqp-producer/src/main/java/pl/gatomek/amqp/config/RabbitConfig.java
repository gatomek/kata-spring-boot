package pl.gatomek.amqp.config;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.gatomek.amqp.properties.RabbitProperties;

@Configuration
@RequiredArgsConstructor
public class RabbitConfig {

    private final RabbitProperties rabbitProperties;

    @Bean
    public Queue createQueue() {
        return new Queue(rabbitProperties.getQueueName(), true);
    }

    @Bean
    public TopicExchange createExchange() {
        return new TopicExchange(rabbitProperties.getExchangeName());
    }

    @Bean
    public Binding createBinding(Queue queue, TopicExchange topicExchange) {
        return BindingBuilder.bind(queue).to(topicExchange).with(rabbitProperties.getRoutingKey());
    }
}

### Configuration of DLQ

```java 
    @Bean
    @Qualifier("rabbitmq.demoQueue")
    public Queue queue() {
        Map<String, Object> deadLetter = new HashMap<>();
        deadLetter.put("x-dead-letter-exchange", "rabbitmq.demoDLExchange");
        deadLetter.put("x-max-length", 1000);

        return new Queue(queueName, false, false, false, deadLetter);
    }
```
https://medium.com/@ravinduperera1229/rabbitmq-with-spring-boot-1935ed42da6a


```java
    @Bean
    public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory() {
        final SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory());
        factory.setMessageConverter(converter());
        factory.setConcurrentConsumers(1);
        factory.setMaxConcurrentConsumers(10);
        factory.setAcknowledgeMode(AcknowledgeMode.NONE);
        factory.setAdviceChain(setRetries());

        return factory;
    }
```
https://medium.com/@ravinduperera1229/rabbitmq-with-spring-boot-1935ed42da6a


### Tworzenie administratora

```java
    @Bean
    public AmqpAdmin amqpAdmin() {
        return new RabbitAdmin(connectionFactory());
    }
```

```java
    @Bean
    public ErrorHandler errorHandler() {
        return new ConditionalRejectingErrorHandler(new MyFatalExceptionStrategy());
    }
```

```java
    public static class MyFatalExceptionStrategy extends ConditionalRejectingErrorHandler.DefaultExceptionStrategy {
        @Override
        public boolean isFatal(Throwable t) {
            if (t instanceof ListenerExecutionFailedException) {
                ListenerExecutionFailedException lefe = (ListenerExecutionFailedException) t;
                log.error("Failed to process inbound message from queue "
                        + lefe.getFailedMessage().getMessageProperties().getConsumerQueue()
                        + "; failed message: " + lefe.getFailedMessage(), t);
            }
            return super.isFatal(t);
        }
    }
```

## Configuration

### Creating and adding converter to registry

```java
public class StringToPersonConverter implements Converter<String, Person> {
    @Override
    public Person convert(String source) {
        // ...
    }
}
```

```java
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new StringToPersonConverter());
    }
}
```

### Defining converter as component - no need for adding manually to registry

* @Component annotation added

```java
@Component
public class StringToPersonConverter implements Converter<String, Person> {
    @Override
    public Person convert(String source) {
        // ...
    }
}
```

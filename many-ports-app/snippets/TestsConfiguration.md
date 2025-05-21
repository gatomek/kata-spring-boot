
### Common configuration

```java
@SpringBootApplication
public class ManyPortsAppApplication {
    public static void main(String[] args) {
        SpringApplication.run(ManyPortsAppApplication.class, args);
    }
}
```

```java
@SpringBootTest
class ManyPortsAppApplicationTests {
    @Test
    void contextLoads() {
    }
}
```

### Detailed configuration 1

```java
@ComponentScan(
        basePackages = {
                "pl.gatomek.manyportsapp.config",
                "pl.gatomek.manyportsapp.random.rest",
                "pl.gatomek.manyportsapp.uuid.rest"
        })
@EnableAutoConfiguration
@Configuration

public class ManyPortsAppApplication {
    public static void main(String[] args) {
        SpringApplication.run(ManyPortsAppApplication.class, args);
    }
}
```

```java
@SpringBootTest(classes = {pl.gatomek.manyportsapp.ManyPortsAppApplication.class})
class ManyPortsAppApplicationTests {
    @Test
    void contextLoads() {
    }
}
```

### Detailed configuration 2

```java
@ComponentScan(
        basePackages = {
                "pl.gatomek.manyportsapp.config",
                "pl.gatomek.manyportsapp.random.rest",
                "pl.gatomek.manyportsapp.uuid.rest"
        })
@EnableAutoConfiguration
@SpringBootConfiguration

public class ManyPortsAppApplication {
    public static void main(String[] args) {
        SpringApplication.run(ManyPortsAppApplication.class, args);
    }
}
```

```java
@SpringBootTest
class ManyPortsAppApplicationTests {
    @Test
    void contextLoads() {
    }
}
```





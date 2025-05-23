
```java
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(properties = {"management.port=0"})
public class HelloWorldApplicationTests {
    //...
}
```

vs.

```java
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT,
        properties = {"server.port=8080", "internal.port=5000"}
)
public class ManyPortsApplicationTests {
    //...
}
```
package pl.gatomek.manyportsapp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.gatomek.manyportsapp.random.rest.RandomNumberRestController;
import pl.gatomek.manyportsapp.uuid.rest.UuidRestController;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ManyPortsApplication2Tests {

    @Autowired
    private UuidRestController uuidRestController;

    @Autowired
    private RandomNumberRestController randomNumberRestController;

    @Test
    void contextLoads() {
        assertThat(uuidRestController).isNotNull();
        assertThat(randomNumberRestController).isNotNull();
    }
}

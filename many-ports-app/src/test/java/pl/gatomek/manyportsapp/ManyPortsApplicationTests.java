package pl.gatomek.manyportsapp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClient;
import pl.gatomek.manyportsapp.config.CustomConfig;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT,
        properties = {"server.port=8080", "internal.port=5000"}
)
public class ManyPortsApplicationTests {

    private final static String PRE_ORIGIN = "http://localhost:";
    private final static String UUID_ENDPOINT = "/api/uuid";
    private final static String RANDOM_ENDPOINT = "/api/random";

    @LocalServerPort
    int port;

    @Autowired
    private CustomConfig customConfig;

    @Test
    public void test1() {
        ResponseEntity<UUID> entity = RestClient.create(PRE_ORIGIN + port + UUID_ENDPOINT)
                .get()
                .retrieve()
                .toEntity(UUID.class);

        assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(entity.getBody()).isNotNull();
    }

    @Test
    public void test2() {
        assertThrows(HttpClientErrorException.class, () ->
                RestClient.create(PRE_ORIGIN + port + RANDOM_ENDPOINT)
                        .get()
                        .retrieve()
                        .toEntity(String.class)
        );
    }

    @Test
    public void test3() {
        ResponseEntity<UUID> entity = RestClient.create(PRE_ORIGIN + customConfig.getPort() + UUID_ENDPOINT)
                .get()
                .retrieve()
                .toEntity(UUID.class);

        assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(entity.getBody()).isNotNull();
    }

    @Test
    public void test4() {
        ResponseEntity<Integer> entity = RestClient.create(PRE_ORIGIN + customConfig.getPort() + RANDOM_ENDPOINT)
                .get()
                .retrieve()
                .toEntity(Integer.class);

        assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(entity.getBody()).isBetween(0, 1000);
    }
}

package pl.gatomek.customvalidator;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.gatomek.customvalidator.config.UuidConfig;

@Component
@RequiredArgsConstructor
@Slf4j
public class Runner implements CommandLineRunner {

    private final UuidConfig uuidConfig;

    @Override
    public void run(String... args) {
        log.info("uuid.version: {}", uuidConfig.getVersion());
    }
}

package pl.gatomek.customvalidator;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UuidFactory {
    public UUID makeUuid() {
        return UUID.randomUUID();
    }
}

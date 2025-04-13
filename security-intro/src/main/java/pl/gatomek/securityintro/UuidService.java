package pl.gatomek.securityintro;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UuidService {
    public UUID makeUuid() {
        return UUID.randomUUID();
    }
}

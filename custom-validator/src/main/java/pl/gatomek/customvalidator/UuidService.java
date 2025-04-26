package pl.gatomek.customvalidator;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class UuidService {

    private final UuidFactory uuidFactory;

    public UUID makeUuid(int version) {
        if (version == 4)
            return uuidFactory.makeUuid();

        throw new UnsupportedOperationException("UUID version " + version + " is unsupported");
    }
}

package pl.gatomek.customvalidator;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class UuidService {

    private final UuidFactory uuidFactory;

    public UUID makeUuid(Integer version) {
        if (version == null || version.equals(4))
            return uuidFactory.makeUuid();

        throw new UnsupportedOperationException("UUID version " + version + " is unsupported");
    }
}

package pl.gatomek.manyportsapp.uuid.usecase;

import java.util.UUID;

public class UuidService implements GenerateUuidUseCase {

    @Override
    public UUID generate() {
        return UUID.randomUUID();
    }
}

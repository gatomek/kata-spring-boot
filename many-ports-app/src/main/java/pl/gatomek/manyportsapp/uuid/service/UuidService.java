package pl.gatomek.manyportsapp.uuid.service;

import pl.gatomek.manyportsapp.uuid.usecase.GenerateUuidUseCase;

import java.util.UUID;

class UuidService implements GenerateUuidUseCase {

    @Override
    public UUID generate() {
        return UUID.randomUUID();
    }
}

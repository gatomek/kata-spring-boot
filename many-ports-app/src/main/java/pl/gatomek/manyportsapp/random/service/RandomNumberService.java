package pl.gatomek.manyportsapp.random.service;

import pl.gatomek.manyportsapp.random.usecase.GenerateRandomNumberUseCase;

import java.util.concurrent.ThreadLocalRandom;

class RandomNumberService implements GenerateRandomNumberUseCase {

    @Override
    public int generate() {
        return ThreadLocalRandom.current().nextInt(1000);
    }
}

package pl.gatomek.manyportsapp.random.usecase;

import java.util.concurrent.ThreadLocalRandom;

public class RandomNumberService implements GenerateRandomNumberUseCase {

    @Override
    public int generate() {
        return ThreadLocalRandom.current().nextInt(1000);
    }
}

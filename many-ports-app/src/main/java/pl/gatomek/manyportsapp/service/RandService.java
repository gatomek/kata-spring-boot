package pl.gatomek.manyportsapp.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;

@Service
public class RandService {
    public int makeRand() {
        return ThreadLocalRandom.current().nextInt(1000);
    }
}

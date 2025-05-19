package pl.gatomek.manyportsapp.service;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UuidService {
    public UUID makeUuid() {
        return UUID.randomUUID();
    }
}

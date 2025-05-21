package pl.gatomek.manyportsapp.uuid.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.gatomek.manyportsapp.uuid.usecase.GenerateUuidUseCase;

import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class UuidRestController {

    private final GenerateUuidUseCase uuidUseCase;

    @GetMapping("/uuid")
    public UUID generateUuid() {
        return uuidUseCase.generate();
    }
}

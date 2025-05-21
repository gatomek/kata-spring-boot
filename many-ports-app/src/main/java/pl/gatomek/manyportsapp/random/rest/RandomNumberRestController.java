package pl.gatomek.manyportsapp.random.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.gatomek.manyportsapp.random.usecase.GenerateRandomNumberUseCase;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class RandomNumberRestController {

    private final GenerateRandomNumberUseCase randomNumberUseCase;

    @GetMapping("/random")
    public Integer generateRandomNumber() {
        return randomNumberUseCase.generate();
    }
}

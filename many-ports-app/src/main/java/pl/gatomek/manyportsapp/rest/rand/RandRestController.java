package pl.gatomek.manyportsapp.rest.rand;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.gatomek.manyportsapp.service.RandService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class RandRestController {

    private final RandService randService;

    @GetMapping("/rand")
    public Integer makeRand() {
        return randService.makeRand();
    }
}

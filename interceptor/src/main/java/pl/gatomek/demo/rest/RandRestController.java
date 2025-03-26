package pl.gatomek.demo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequestMapping("/api")
public class RandRestController {

    private final Random random = new Random();

    @GetMapping("/rand")
    public @ResponseBody Integer makeRand() {
        return random.nextInt(1000);
    }
}

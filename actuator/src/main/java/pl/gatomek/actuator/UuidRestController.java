package pl.gatomek.actuator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping( "/api")
public class UuidRestController {

    @GetMapping("/uuid")
    public UUID getUuid() {
        return UUID.randomUUID();
    }
}

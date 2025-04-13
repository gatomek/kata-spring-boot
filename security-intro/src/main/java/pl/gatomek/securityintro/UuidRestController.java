package pl.gatomek.securityintro;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api")
public class UuidRestController {

    final private UuidService uuidService;

    public UuidRestController(UuidService uuidService) {
        this.uuidService = uuidService;
    }

    @GetMapping("/uuid")
    public UUID makeUuid() {
        return uuidService.makeUuid();
    }
}

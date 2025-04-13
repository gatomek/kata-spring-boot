package pl.gatomek.securitybasics;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class UuidRestController {

    private final UuidService uuidService;

    @GetMapping("/uuid")
    public UUID makeUuid() {
        return uuidService.makeUuid();
    }
}

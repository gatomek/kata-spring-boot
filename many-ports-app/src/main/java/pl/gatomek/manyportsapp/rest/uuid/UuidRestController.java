package pl.gatomek.manyportsapp.rest.uuid;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.gatomek.manyportsapp.service.UuidService;

import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/")
public class UuidRestController {

    private final UuidService uuidService;

    @GetMapping("/uuid")
    public UUID makeUUID() {
        return uuidService.makeUuid();
    }
}

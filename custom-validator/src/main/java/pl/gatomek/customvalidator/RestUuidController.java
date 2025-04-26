package pl.gatomek.customvalidator;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.gatomek.customvalidator.validator.custom.uuidversion.UuidVersionConstraint;

import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class RestUuidController {

    private final UuidService uuidService;

    @GetMapping("/uuid/{version}")
    public UUID makeUuid(@PathVariable @UuidVersionConstraint int version) {
        return uuidService.makeUuid(version);
    }
}

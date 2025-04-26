package pl.gatomek.customvalidator;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.gatomek.customvalidator.validator.custom.uuidversion.UuidVersionConstraint;

import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class UuidRestController {

    private final UuidService uuidService;

    @GetMapping(value = {"/uuid/{version}", "/uuid"})
    public UUID makeUuid(@PathVariable(required = false) @UuidVersionConstraint Integer version) {
        return uuidService.makeUuid(version);
    }

    @GetMapping("/uuid2")
    public UUID makeUuid2(@RequestParam(name = "v", required = false) @UuidVersionConstraint Integer version) {
        return uuidService.makeUuid(version);
    }
}

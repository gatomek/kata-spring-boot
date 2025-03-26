package pl.gatomek.demo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api")
public class UuidRestController {

    @GetMapping("/uuid")
    public @ResponseBody UUID makeUuid() {
        return UUID.randomUUID();
    }


}

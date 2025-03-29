package pl.gatomek.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.UUID;

@Controller
public class ExtendedUuidController {

    @GetMapping("/extended-uuid")
    public String index(@RequestParam(name = "showDetails", required = false) Boolean showDetails,
                        Model model) {
        model.addAttribute("features", Arrays.asList("Feature 1", "Feature 2", "Feature 3"));
        model.addAttribute("showDetails", showDetails);

        return "extendedUuid";
    }

    @GetMapping("/fragments/uuid")
    public String uuid( Model model) {
        model.addAttribute("uuid", UUID.randomUUID());
        return "fragments/uuid.html :: uuid";
    }
}

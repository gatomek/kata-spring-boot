package pl.gatomek.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.UUID;

@Controller
public class UuidController {

    @GetMapping("/uuid")
    public String viewIndex(Model model) {
        model.addAttribute("uuid", UUID.randomUUID());
        return "uuid";
    }
}

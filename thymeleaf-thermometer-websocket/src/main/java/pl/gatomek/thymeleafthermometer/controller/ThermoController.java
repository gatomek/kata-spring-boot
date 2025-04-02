package pl.gatomek.thymeleafthermometer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ThermoController {

    @GetMapping( "/")
    public String index() {
        return "index";
    }
}

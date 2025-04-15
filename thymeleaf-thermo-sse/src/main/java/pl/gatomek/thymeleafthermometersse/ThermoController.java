package pl.gatomek.thymeleafthermometersse;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class ThermoController {

    private final ThermoService thermoService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/fragments/temp")
    public String getTemp(Model model) {
        model.addAttribute("temp", thermoService.getTemp());
        return "fragments/temp :: temp";
    }
}

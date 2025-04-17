package pl.gatomek.thymeleafthermometersse;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@RequiredArgsConstructor
@Controller
public class ThermoController {

    private final ThermoService thermoService;
    private final ChangeNotifier changeNotifier;

    @GetMapping(value="/sse", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public SseEmitter streamSse() {
        SseEmitter emitter = new SseEmitter( 60_000L);

        emitter.onTimeout(()-> {
            emitter.complete();
            changeNotifier.remove( emitter);
        });

        changeNotifier.add( emitter);
        return emitter;
    }

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

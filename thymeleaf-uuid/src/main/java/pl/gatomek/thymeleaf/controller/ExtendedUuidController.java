package pl.gatomek.thymeleaf.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Arrays;
import java.util.UUID;

@Controller
@Scope( "session")
public class ExtendedUuidController {

    @GetMapping("/extended-uuid")
    public String extendedUuid(HttpSession session, Model model) {

        if( showDetails( session)) {
            model.addAttribute("showDetails", 1);
            model.addAttribute("features", Arrays.asList("Feature 1", "Feature 2", "Feature 3"));
        }
        else {
            model.addAttribute("showDetails", 0);
        }

        return "extendedUuid";
    }

    @GetMapping("/extended-uuid-with-details")
    public RedirectView extendedUuidWithDetails(HttpSession session) {
        session.setAttribute("details", 1);
        return new RedirectView("/extended-uuid");
    }

    @GetMapping("/extended-uuid-without-details")
    public RedirectView extendedUuidWithoutDetails(HttpSession session) {
        session.setAttribute("details", 0);
        return new RedirectView("/extended-uuid");
    }

    @GetMapping("/fragments/uuid")
    public String uuid(Model model) {

        model.addAttribute("uuid", UUID.randomUUID());
        return "fragments/uuid.html :: uuid";
    }

    private boolean showDetails( HttpSession session) {
        Integer details = (Integer) session.getAttribute("details");
        return details != null && details.equals(1);
    }
}

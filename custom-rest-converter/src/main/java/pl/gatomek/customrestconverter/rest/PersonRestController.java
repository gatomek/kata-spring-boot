package pl.gatomek.customrestconverter.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.gatomek.customrestconverter.model.Person;
import pl.gatomek.customrestconverter.service.PersonService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/person")
public class PersonRestController {

    private final PersonService personService;

    @PostMapping("/create")
    public void createPerson(@RequestParam Person person) {
        personService.create(person);
    }

    @PostMapping("/create2")
    public void createPersonV2(Person person) {
        personService.create(person);
    }
}

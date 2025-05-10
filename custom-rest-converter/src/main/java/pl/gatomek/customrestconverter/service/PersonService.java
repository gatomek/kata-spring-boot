package pl.gatomek.customrestconverter.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.gatomek.customrestconverter.model.Person;

@Slf4j
@Service
public class PersonService {
    public void create(Person person) {
        log.info("Person created: {}", person);
    }
}

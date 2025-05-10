package pl.gatomek.customrestconverter.converter;

import org.springframework.core.convert.converter.Converter;
import pl.gatomek.customrestconverter.model.Person;
import pl.gatomek.customrestconverter.model.Sex;

public class StringToPersonConverter implements Converter<String, Person> {
    @Override
    public Person convert(String source) {
        String[] data = source.split(",");
        String name = data[0];
        int age = Integer.parseInt(data[1]);
        Sex sex = Sex.fromDesc(data[2]);

        return Person.of(name, age, sex);
    }
}

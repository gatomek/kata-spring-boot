package pl.gatomek.thymeleafthermometersse;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class TempRegister {
    private int temp = 0;
}

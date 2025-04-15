package pl.gatomek.thymeleafthermometersse;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ThermoService {
    private final TempRegister tempRegister;

    public Integer getTemp() {
        return tempRegister.getTemp();
    }
}

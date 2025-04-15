package pl.gatomek.thymeleafthermometersse;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.ThreadLocalRandom;

@RequiredArgsConstructor
@Component
public class ThermoScheduledTask {
    private final TempRegister tempRegister;

    @Scheduled(fixedDelay = 5000)
    public void reportCurrentTemperature() {
        tempRegister.setTemp(ThreadLocalRandom.current().nextInt(0, 100));
    }
}

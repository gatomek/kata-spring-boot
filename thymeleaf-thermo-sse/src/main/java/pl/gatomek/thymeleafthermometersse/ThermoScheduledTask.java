package pl.gatomek.thymeleafthermometersse;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@RequiredArgsConstructor
@Component
public class ThermoScheduledTask {
    private final TempRegister tempRegister;
    private final ChangeNotifier changeNotifier;

    private final AtomicInteger currTemp = new AtomicInteger(0);

    @Scheduled(timeUnit = TimeUnit.SECONDS, fixedDelay = 5)
    public void reportCurrentTemperature() {
        int random = ThreadLocalRandom.current().nextInt(0, 100);
        int ct = (random % 2 == 0) ? currTemp.incrementAndGet() : currTemp.decrementAndGet();

        tempRegister.setTemp( ct);
        changeNotifier.raiseSseEvents( ct);
    }
}

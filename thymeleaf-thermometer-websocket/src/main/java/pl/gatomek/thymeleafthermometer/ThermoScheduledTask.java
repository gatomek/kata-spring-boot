package pl.gatomek.thymeleafthermometer;

import lombok.RequiredArgsConstructor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import pl.gatomek.thymeleafthermometer.model.TempMessage;

import java.util.Random;

@EnableScheduling
@RequiredArgsConstructor
@Component
public class ThermoScheduledTask {

    private final Random random = new Random();
    private final SimpMessagingTemplate messagingTemplate;

    @Scheduled(fixedDelay = 5000)
    public void reportCurrentTemperature() {
        messagingTemplate.convertAndSend("/topic/messages", new TempMessage(random.nextInt(100)));
    }
}

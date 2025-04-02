package pl.gatomek.thymeleafthermometer.model;


import lombok.*;

import java.time.Instant;

@Data
public class TempMessage {

    public TempMessage(int temp) {
        this.dateTime = Instant.now();
        this.temp = temp;
    }

    private Instant dateTime;
    private int temp;
}

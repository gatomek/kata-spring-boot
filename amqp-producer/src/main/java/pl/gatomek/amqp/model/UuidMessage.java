package pl.gatomek.amqp.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@AllArgsConstructor
@Data
public class UuidMessage implements Serializable {
    private UUID uuid;
}

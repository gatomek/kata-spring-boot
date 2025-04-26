package pl.gatomek.customvalidator.config;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;
import pl.gatomek.customvalidator.validator.custom.uuidversion.UuidVersionConstraint;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "uuid")
@Validated
@ToString
public class UuidConfig {

    @UuidVersionConstraint
    private Integer version;


}

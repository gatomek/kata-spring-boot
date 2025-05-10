package pl.gatomek.customrestconverter.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import pl.gatomek.customrestconverter.converter.StringToPersonConverter;
import pl.gatomek.customrestconverter.converter.StringToPersonResolver;

import java.util.List;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new StringToPersonConverter());
    }

    @Override
    public void addArgumentResolvers( List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add( new StringToPersonResolver());
    }
}

package pl.gatomek.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import pl.gatomek.demo.interceptor.AuthHandlerInterceptor;
import pl.gatomek.demo.interceptor.LogHandlerInterceptor;
import pl.gatomek.demo.interceptor.RandHandlerInterceptor;
import pl.gatomek.demo.interceptor.UuidHandlerInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(new AuthHandlerInterceptor()).order(0);
        registry.addInterceptor(new LogHandlerInterceptor()).order(1);

        registry.addInterceptor(new UuidHandlerInterceptor()).addPathPatterns("/api/uuid");
        registry.addInterceptor(new RandHandlerInterceptor()).addPathPatterns("/api/rand");
    }
}

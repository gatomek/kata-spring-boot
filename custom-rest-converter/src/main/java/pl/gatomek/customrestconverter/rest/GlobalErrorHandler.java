package pl.gatomek.customrestconverter.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalErrorHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(UnsupportedOperationException.class)
    public void handleUnsupportedOperationException(UnsupportedOperationException ex) {
        log.error("Unsupported Operation Exception: {}", ex.getMessage());
    }
}

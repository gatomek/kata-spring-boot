package pl.gatomek.customvalidator;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.method.ParameterValidationResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.HandlerMethodValidationException;

import java.util.List;

@Slf4j
@RestControllerAdvice
public class GlobalErrorHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(UnsupportedOperationException.class)
    public void handleUnsupportedOperationException(UnsupportedOperationException ex) {
        log.error("Unsupported Operation Exception: {}", ex.getMessage());
    }

    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    @ExceptionHandler(HandlerMethodValidationException.class)
    public void handleValidationErrors(HandlerMethodValidationException ex) {
        List<ParameterValidationResult> parameterValidationResults = ex.getParameterValidationResults();
        parameterValidationResults.forEach(result ->
            result.getResolvableErrors().forEach(e ->
                log.error(e.getDefaultMessage())
            )
        );
    }
}

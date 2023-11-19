package pl.bartoszmech.emailsender.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@RestControllerAdvice
public class InvalidEmailHandler {
    @ExceptionHandler(InvalidEmail.class)
    public ResponseEntity<String> handleValidationError(InvalidEmail e) {
        return new ResponseEntity<>(e.getMessage(), BAD_REQUEST);
    }
}
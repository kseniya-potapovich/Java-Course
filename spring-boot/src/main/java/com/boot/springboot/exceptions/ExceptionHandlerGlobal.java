package com.boot.springboot.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class ExceptionHandlerGlobal {

    @ExceptionHandler(value = {CustomValidException.class, jakarta.validation.ValidationException.class})
    public ResponseEntity<HttpStatusCode> customValidExceptionHandler(Exception exception) {
        log.error("Valid exception: " + exception);
        return new ResponseEntity<>(HttpStatus.valueOf(400));
    }

    @ExceptionHandler(value = UsernameNotFoundException.class)
    public ResponseEntity<HttpStatusCode> usernameNotFoundException(Exception exception) {
        log.error("Username not found: " + exception);
        return new ResponseEntity<>(HttpStatus.valueOf(401));
    }

    @ExceptionHandler(value = SameUserInDatabase.class)
    public ResponseEntity<HttpStatusCode> sameUserInDatabase(Exception exception) {
        log.error(String.valueOf(exception));
        return new ResponseEntity<>(HttpStatus.valueOf(409));
    }
}

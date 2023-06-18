package com.example.demo.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

     /** Customize the response for ResourceNotFoundException. */
    @ExceptionHandler({ ResourceNotFoundException.class})
    public ResponseEntity handleResourceNotFoundException(ResourceNotFoundException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        System.out.println("inside globalexceptionhandler...");
        return new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST);
    }

    /** Customize the response for UserModificationException. */
    @ExceptionHandler({ UserModificationException.class})
    public ResponseEntity handleUserModificationException(UserModificationException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        return new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST);
    }
}

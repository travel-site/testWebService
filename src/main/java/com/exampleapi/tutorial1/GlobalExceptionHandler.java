package com.exampleapi.tutorial1;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
public class GlobalExceptionHandler{

    @ExceptionHandler(value = productNotFoundException.class)
    public ResponseEntity<Object> exception(productNotFoundException exception){
        return new ResponseEntity<Object>(exception.getMessage(),HttpStatus.NOT_FOUND);
    }
}

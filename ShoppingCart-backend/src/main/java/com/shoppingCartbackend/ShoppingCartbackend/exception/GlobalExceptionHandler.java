package com.shoppingCartbackend.ShoppingCartbackend.exception;

import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
        @ExceptionHandler(ResourceNotFoundException.class)
        public String HandleResourceNotFoundException(ResourceNotFoundException ex){

            return ex.getMessage();
        }

        @ExceptionHandler(MethodArgumentNotValidException.class)
        public ResponseEntity<Map<String,String>> HandleMethodArgumentNotValidException(MethodArgumentNotValidException ex){

            Map<String, String> resp = new HashMap<>();
            ex.getBindingResult().getAllErrors().forEach((error) -> {
                String fieldName = ((FieldError) error).getField();
                String message = error.getDefaultMessage();
                resp.put(fieldName, message);
            });

            return new ResponseEntity<Map<String,String>>(resp, HttpStatus.BAD_REQUEST);
        }
    }

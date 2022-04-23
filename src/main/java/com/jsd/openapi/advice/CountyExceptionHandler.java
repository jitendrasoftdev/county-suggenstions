package com.jsd.openapi.advice;

import com.jsd.openapi.exception.ResultNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class CountyExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    public Map<String, String> handleInvalidArgument(ConstraintViolationException ex) {
        Map<String,String> errors = new HashMap<>();
        ex.getConstraintViolations().stream().forEach(error -> {
            errors.put(error.getPropertyPath().toString(), error.getMessage());
        });
        return errors;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ResultNotFoundException.class)
    public Map<String, String> handleResultNotFoundException(ResultNotFoundException ex) {
        Map<String,String> notFound = new HashMap<>();
        notFound.put("message", ex.getMessage());
        return notFound;
    }


}

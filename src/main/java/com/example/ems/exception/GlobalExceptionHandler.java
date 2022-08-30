package com.example.ems.exception;

import com.example.ems.dto.OutputDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler{

    @ExceptionHandler(ResourceNotFoundException.class)
    public OutputDto handleExceptions(ResourceNotFoundException exception){
        return new OutputDto(null, HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage());
    }
}

package com.example.ems.exception;

import com.example.ems.dto.ErrorDto;
import org.springframework.beans.factory.annotation.Autowired;

public class ResourceNotFoundException extends Exception{
//    public ResourceNotFoundException(String message) {
//        super(message);
//    }
    @Autowired
     private ErrorDto errorDto;

    public ResourceNotFoundException(ErrorDto errorDto) {
        this.errorDto = errorDto;
    }

    public ErrorDto getErrorDto() {
        return errorDto;
    }
}

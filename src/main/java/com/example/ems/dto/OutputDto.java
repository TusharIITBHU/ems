package com.example.ems.dto;

import org.springframework.http.HttpStatus;

public class OutputDto {

    private Object object;
    private HttpStatus httpStatus;
    private String message;

    public OutputDto(Object object, HttpStatus httpStatus, String message) {
        this.object = object;
        this.httpStatus = httpStatus;
        this.message = message;
    }

    public OutputDto(Object object, HttpStatus httpStatus) {
        this.object = object;
        this.httpStatus = httpStatus;
    }

    public Object getObject() {
        return object;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public String getMessage() {
        return message;
    }
}

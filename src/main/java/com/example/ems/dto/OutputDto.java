package com.example.ems.dto;

import org.springframework.http.HttpStatus;

public class OutputDto {

    private Object object;
    private HttpStatus httpStatus;
    private ErrorDto errorDto;

    public OutputDto(Object object, HttpStatus httpStatus, ErrorDto errorDto) {
        this.object = object;
        this.httpStatus = httpStatus;
        this.errorDto = errorDto;
    }

    public OutputDto(Object object, HttpStatus httpStatus) {
        this.object = object;
        this.httpStatus = httpStatus;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public ErrorDto getErrorDto() {
        return errorDto;
    }

    public void setErrorDto(ErrorDto errorDto) {
        this.errorDto = errorDto;
    }
}

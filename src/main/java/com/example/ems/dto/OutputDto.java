package com.example.ems.dto;

import org.springframework.http.HttpStatus;

public class OutputDto<T> {

    private T data;
    private HttpStatus httpStatus;
    private ErrorDto errorDto;

    public OutputDto(T data, HttpStatus httpStatus, ErrorDto errorDto) {
        this.data = data;
        this.httpStatus = httpStatus;
        this.errorDto = errorDto;
    }

    public OutputDto(T data, HttpStatus httpStatus) {
        this.data = data;
        this.httpStatus = httpStatus;
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}

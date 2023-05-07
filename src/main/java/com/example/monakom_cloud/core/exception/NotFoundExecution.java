package com.example.monakom_cloud.core.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundExecution extends RuntimeException {
    public NotFoundExecution(String message){
        super(message);
    }
}

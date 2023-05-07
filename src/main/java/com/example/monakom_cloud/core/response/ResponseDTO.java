package com.example.monakom_cloud.core.response;


import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.function.Consumer;

@Component
public class ResponseDTO {
    public int code = 200;
    public String message = "";
    public Date timestamp = new Date();
    public Object data = null;
    public Object error = null;
    public int total = 0;

    ResponseDTO(){}

    public ResponseDTO(int code, String message, Date timestamp, Object data, Object error, int total){
        this.code = code;
        this.message = message;
        this.timestamp = timestamp;
        this.data = data;
        this.error = error;
        this.total = total;
    }

    public <T> void with(T obj, @NotNull Consumer<T> c) {
        c.accept(obj);
    }
}

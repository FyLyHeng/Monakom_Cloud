package com.example.monakom_cloud.core.response;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.function.Consumer;

@Component
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDTO {
    public int code = 200;
    public String message = "";
    public Date timestamp = new Date();
    public Object data = null;
    public Object error = null;
    public int total = 0;


    public ResponseDTO( Integer code, String message ,Object error){
        this.code = code;
        this.message = message;
        this.error = error;
    }

    public <T> void with(T obj, @NotNull Consumer<T> c) {
        c.accept(obj);
    }
}

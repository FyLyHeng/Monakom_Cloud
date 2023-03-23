package com.example.monakom_cloud.core;


import java.util.Date;

public class ResponseDTO {
    public int code;
    public String message;
    public Date timestamp;
    public Object data;
    public Object error;
    public Long total;

    ResponseDTO(){}

    ResponseDTO( int code, String message, Date timestamp, Object data, Object error, Long total){
        this.code = code;
        this.message = message;
        this.timestamp = timestamp;
        this.data = data;
        this.error = error;
        this.total = total;
    }

}

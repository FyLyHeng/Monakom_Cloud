package com.example.monakom_cloud.core.response;


import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JSONFormat implements ResponseFormat {

    private final HttpStatus defaultHttpStatus = HttpStatus.OK;


    public ResponseDTO responseObj(Object data){

        return new ResponseDTO(
                defaultHttpStatus.value(),
                defaultHttpStatus.getReasonPhrase(),
                new Date(),
                data,
                null,
                0
        );
    }

}

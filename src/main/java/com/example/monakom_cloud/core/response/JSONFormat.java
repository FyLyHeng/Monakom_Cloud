package com.example.monakom_cloud.core.response;


import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class JSONFormat implements ResponseFormat {

    private final ResponseDTO responseDTO;
    private final HttpStatus defaultHttpStatus = HttpStatus.OK;

    public JSONFormat(ResponseDTO responseDTO) {
        this.responseDTO = responseDTO;
    }


    public ResponseDTO responseID(){

        responseDTO.with(responseDTO, it -> {
            it.code = defaultHttpStatus.value();
            it.message = "set value using with";
            it.data = "empty here wait and see power of Java";
        });
        return responseDTO;
    }

    public ResponseDTO responseObj(Object data){

        responseDTO.with(responseDTO, it -> {
            it.code = defaultHttpStatus.value();
            it.message = "set value using with";
            it.data = data;
        });
        return responseDTO;
    }

}

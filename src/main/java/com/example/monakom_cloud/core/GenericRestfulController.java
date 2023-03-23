package com.example.monakom_cloud.core;

import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;

public abstract class GenericRestfulController {


    @GetMapping("/all")
    public ResponseDTO All() {
        return new ResponseDTO(1,"message", new Date(), "","", 1L);
    }
}

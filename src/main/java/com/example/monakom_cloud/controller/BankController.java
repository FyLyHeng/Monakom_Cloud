package com.example.monakom_cloud.controller;

import com.example.monakom_cloud.core.response.JSONFormat;
import com.example.monakom_cloud.core.response.ResponseDTO;
import com.example.monakom_cloud.repository.BankRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@Slf4j
@RestController
@RequestMapping("/bank")
@AllArgsConstructor
public class BankController  {

    @Autowired
    private JSONFormat jsonFormat;
    @Autowired
    private BankRepository bankRepository;

//    public BankController() {
//        //super(baseRepository);
//        log.warn("bank controller may init in default cont");
//    }

    @GetMapping("/list-dto")
    public ResponseDTO list() {
        return jsonFormat.responseObj(Arrays.asList("string1", "string2"));//bankRepository.findAll()
    }
}

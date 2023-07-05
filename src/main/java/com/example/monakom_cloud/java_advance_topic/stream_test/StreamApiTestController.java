package com.example.monakom_cloud.java_advance_topic.stream_test;

import com.example.monakom_cloud.dto.TransactionDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("stream-api")
@Slf4j
public class StreamApiTestController {


    //    @Qualifier("mapStructTestService")
    @Qualifier("v1")
    @Autowired
    StreamApiTestService service;


    @GetMapping("test1")
    public List<TransactionDTO> test1() {
        return service.test1(service.getAllTransaction());
    }


    @GetMapping("test2")
    public List<String> test2() {
        return service.test2(service.getAllTransaction());
    }

    @GetMapping("test3")
    public List<Trader> test3() {
        return service.test3(service.getAllTransaction());
    }
    @GetMapping("test4")
    public String test4() {
        return service.test4(service.getAllTransaction());
    }

    @GetMapping("test5")
    public Boolean test5() {
        return service.test5(service.getAllTransaction());
    }

    @GetMapping("test6")
    public Integer test6() {
        return service.test6(service.getAllTransaction());
    }

}

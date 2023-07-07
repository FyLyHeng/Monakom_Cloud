package com.example.monakom_cloud.java_advance_topic.stream_api_test;

import com.example.monakom_cloud.java_advance_topic.map_struct_test.MapStructTestService;
import com.example.monakom_cloud.java_advance_topic.map_struct_test.TransactionDTO;
import com.example.monakom_cloud.java_advance_topic.stream_api_test.model.Trader;
import com.example.monakom_cloud.java_advance_topic.stream_api_test.service.StreamApiTestService;
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


    @Autowired
    StreamApiTestService service;

    @Autowired
    @Qualifier("v1")
    MapStructTestService mapStructTestService;


    @GetMapping("struct-1")
    public List<TransactionDTO> struct1() {
        return mapStructTestService.findAllByYearAndName(service.getAllTransaction());
    }
    @GetMapping("struct-2")
    public List<TransactionDTO> struct2() {
        return mapStructTestService.findAllByYearAndName01(service.getAllTransaction());
    }

    @GetMapping("test2")
    public List<String> test2() {
        return service.listAllAndSelectCity(service.getAllTransaction());
    }

    @GetMapping("test3")
    public List<Trader> test3() {
        return service.findAllByCityAndSelectTrader(service.getAllTransaction());
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

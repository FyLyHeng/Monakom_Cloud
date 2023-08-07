package com.example.monakom_cloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/app")
public class AppInfo  {



    @GetMapping("/info")
    public Map<String,String> Info(){

        return Map.of(
                "App","Clone Munakom Cloud solution",
                "Version","1.0.0.1",
                "ReleaseDate","2023-03-23",
                "Status","Stable"
        );
    }


    @GetMapping("/all")
    public String all() {
        System.out.println("Me override ab base class in All");
        return "";
    }

    @GetMapping("/list-dto")
    public String list() {
        return "";//jsonFormat.responseObj(Arrays.asList("string1", "string2"));//bankRepository.findAll()
    }
}

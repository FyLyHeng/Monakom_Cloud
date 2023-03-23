package com.example.monakom_cloud.controller;

import com.example.monakom_cloud.core.GenericRestfulController;
import com.example.monakom_cloud.core.ResponseDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/app")
public class AppInfo extends GenericRestfulController {

    @GetMapping("/info")
    public Map<String,String> Info(){

        return Map.of(
                "App","Clone Munakom Cloud solution",
                "Version","1.0.0.1",
                "ReleaseDate","2023-03-23",
                "Status","Stable"
        );
    }

    @Override
    @GetMapping("/v2/all")
    public ResponseDTO All() {
        System.out.println("Me override ab base class in All");
        return super.All();
    }
}

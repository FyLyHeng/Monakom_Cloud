package com.example.monakom_cloud;

import com.example.monakom_cloud.core.response.JSONFormat;
import com.example.monakom_cloud.core.response.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Map;

@RestController
@RequestMapping("/app")
public class AppInfoController {

    private final JSONFormat jsonFormat;

    @Autowired
    AppInfoController(JSONFormat jsonFormat) {
        this.jsonFormat = jsonFormat;
    }


    @GetMapping("/info")
    public ResponseDTO Info(){

        var result =  Map.of(
                "App","Clone Munakom Cloud solution",
                "Version","1.0.0.1",
                "ReleaseDate","2023-03-23",
                "Status","Stable"
        );

        return jsonFormat.responseObj(result);
    }


    @GetMapping("/all")
    public String all() {
        System.out.println("Me override ab base class in All");
        return "";
    }

    @GetMapping("/list-dto")
    public ResponseDTO list() {
        return jsonFormat.responseObj(Arrays.asList("string1", "string2"));
    }
}

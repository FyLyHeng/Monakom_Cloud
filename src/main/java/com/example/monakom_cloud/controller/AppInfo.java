package com.example.monakom_cloud.controller;

import com.example.monakom_cloud.core.GenericRestfulController;
import com.example.monakom_cloud.core.repo.BaseRepository;
import com.example.monakom_cloud.core.response.JSONFormat;
import com.example.monakom_cloud.core.response.ResponseDTO;
import com.example.monakom_cloud.model.pgw.Bank;
import com.example.monakom_cloud.model.pgw.BankDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/app")
public class AppInfo extends GenericRestfulController<Bank> {
    public AppInfo(JSONFormat jsonResponse, BaseRepository<Bank> baseRepository) {
        super(jsonResponse, baseRepository, resouceName);
    }


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
    @GetMapping("/all")
    public ResponseDTO all() {
        System.out.println("Me override ab base class in All");
        return super.all();
    }

    @GetMapping("/list-dto")
    public ResponseDTO list() {
        return super.list(BankDto.class);
    }
}

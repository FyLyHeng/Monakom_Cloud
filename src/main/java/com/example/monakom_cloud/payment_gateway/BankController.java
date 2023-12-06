package com.example.monakom_cloud.payment_gateway;

import com.example.monakom_cloud.core.GenericRestfulController;
import com.example.monakom_cloud.core.response.JSONFormat;
import com.example.monakom_cloud.core.response.ResponseDTO;
import com.example.monakom_cloud.payment_gateway.model.Bank;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@Slf4j
@RestController
@RequestMapping("/bank")
public class BankController extends GenericRestfulController<Bank> {
    @Autowired
    BankController(JSONFormat jsonFormat, BankRepository repository){
        super(jsonFormat, repository);
    }

    @Override
    @PostMapping
    public ResponseDTO create(@RequestBody Bank entity) {
        log.warn("I need to add some log before save");
        return jsonFormat.responseObj(repository.save(entity));
    }

    @GetMapping("/list-dto")
    public ResponseDTO list() {
        return jsonFormat.responseObj(Arrays.asList("string1", "string2"));
    }


}

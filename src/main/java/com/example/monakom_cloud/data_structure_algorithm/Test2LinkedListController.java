package com.example.monakom_cloud.data_structure_algorithm;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("ll")
public class Test2LinkedListController {


    @GetMapping("/test1")
    public String singleLinkedList(){
        return "";
    }

}

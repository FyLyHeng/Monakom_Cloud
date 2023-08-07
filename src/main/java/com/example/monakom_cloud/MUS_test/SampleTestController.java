package com.example.monakom_cloud.MUS_test;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("mus-test")
public class SampleTestController {



    @GetMapping("/test1")
    public int test1(@RequestParam int[] arr) {

        int l = arr.length;


        return 1;
    }



    @GetMapping("/test2")
    public int test2(@RequestParam int[] arr) {
        int even = 0;
        int ood = 0;

        for (int element : arr) {

            if (element % 2 == 0) {
                even += element;
            } else {
                ood += element;
            }
        }

        return ood-even;

    }

}

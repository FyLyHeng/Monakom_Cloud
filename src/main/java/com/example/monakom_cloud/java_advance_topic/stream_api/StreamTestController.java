package com.example.monakom_cloud.java_advance_topic.stream_api;

import com.example.monakom_cloud.java_advance_topic.ObjectTest;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTestController {


    void test1() {

        List<ObjectTest> cars = Arrays.asList(
                new ObjectTest(1000, "BMW"),
                new ObjectTest(1000, "Honda"),
                new ObjectTest(1000, "Audi")
        );

        List<Integer> carNameLength = cars.stream()
                .map(ObjectTest::getBrand)
                .map(String::length)
                .collect(Collectors.toList());
    }

    void test2() throws Exception {

        List<Integer> numbers = Arrays.asList(1,2,3,4,5);

        var result = numbers.stream()
                .map(n-> n*n)
                .collect(Collectors.toList());

        Integer r1 = numbers.stream().filter(a->a==1).findFirst().orElseThrow();
        Integer r2 = numbers.stream().filter(a->a==1).findFirst().orElseThrow(Exception::new); // = new Exception();
        Integer r3 = numbers.stream().filter(a->a==1).findFirst().orElseThrow(() -> new Exception("filter r1 not found"));
    }
}

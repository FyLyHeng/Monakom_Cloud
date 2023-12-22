package com.example.monakom_cloud.java_feature_8_17.java8.optional_test;


import lombok.*;

import java.util.Optional;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Person {
    private String name;
    private Integer age;
    private Optional<Car> car;
}

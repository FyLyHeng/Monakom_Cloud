package com.example.monakom_cloud.java_advance_topic.optional_test;


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

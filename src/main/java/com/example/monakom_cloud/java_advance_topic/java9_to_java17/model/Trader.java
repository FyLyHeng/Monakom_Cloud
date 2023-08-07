package com.example.monakom_cloud.java_advance_topic.java9_to_java17.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Trader {

    private String name;
    private String city;
    private EconomicClass economicClass;

}

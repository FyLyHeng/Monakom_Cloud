package com.example.monakom_cloud.java_feature_8_17.java9_to_java17.model;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Transaction {

    private int year;
    private double value;
    private boolean isExpansive;
    private Trader trader;
}

package com.example.monakom_cloud.java_advance_topic.stream_api_test.model;


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

package com.example.monakom_cloud.java_advance_topic.stream_test;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Transaction {

    private int year;
    private double value;
    private Trader trader;
}

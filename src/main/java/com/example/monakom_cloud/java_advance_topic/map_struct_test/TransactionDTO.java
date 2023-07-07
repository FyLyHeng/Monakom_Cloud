package com.example.monakom_cloud.java_advance_topic.map_struct_test;

import lombok.*;


@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDTO {
    private int year;
    private double value;
    private String traderName;
}



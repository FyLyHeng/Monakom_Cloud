package com.example.monakom_cloud.java_feature_8_17.java8.map_struct_test;

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



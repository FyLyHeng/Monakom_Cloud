package com.example.monakom_cloud.dto;

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



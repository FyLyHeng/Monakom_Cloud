package com.example.monakom_cloud.java_advance_topic.stream_api_test.service;

import com.example.monakom_cloud.java_advance_topic.stream_api_test.model.Transaction;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StreamApiNumericTestService {


    public double sumOfTnxValue(List<Transaction> transactions) {
        return transactions.stream().mapToDouble(Transaction::getValue).sum();
    }
}

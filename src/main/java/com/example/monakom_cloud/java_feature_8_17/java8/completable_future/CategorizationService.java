package com.example.monakom_cloud.java_feature_8_17.java8.completable_future;

import com.example.monakom_cloud.java_feature_8_17.java8.completable_future.model.Category;
import com.example.monakom_cloud.java_feature_8_17.java8.completable_future.model.Transaction;

public class CategorizationService {

    public static Category categorizeTransaction(Transaction transaction) {
        delay();
        return new Category("Category_" + transaction.getId());
    }

    public static void delay() {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}


package com.example.monakom_cloud.java_feature_8_17.java8.stream_api_test.service;

import com.example.monakom_cloud.java_feature_8_17.java8.stream_api_test.model.EconomicClass;
import com.example.monakom_cloud.java_feature_8_17.java8.stream_api_test.model.Transaction;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@Slf4j
public class StreamApiTestServiceV1 {


    public double sumOfTnxValue(List<Transaction> transactions) {
        double style1 = transactions.stream().mapToDouble(Transaction::getValue).sum();

        double style2 = transactions.stream().collect(Collectors.summingDouble(Transaction::getValue));

        return style1;
    }
    public double getAvgOfValue (List<Transaction> transactions) {

        return transactions.stream().collect(Collectors.averagingDouble(Transaction::getValue));
    }
    public DoubleSummaryStatistics summaryStatic (List<Transaction> transactions) {
        return transactions
                .stream()
                .collect(Collectors.summarizingDouble(Transaction::getValue));
    }
    public long countList(List<Transaction> transactions) {
        return transactions.size();
    }
    public Optional<Double> findMaxValue (List<Transaction> transactions) {
        Optional<Double> style1 = transactions.stream()
                .max(Comparator.comparing(Transaction::getValue))
                .map(Transaction::getValue);


        Optional<Double> style2 = transactions.stream()
                .collect(Collectors
                        .maxBy(Comparator.comparing(Transaction::getValue))
                ).map(Transaction::getValue);


        return style1;
    }





    // Test Join String
    public String listTxJoinStringByPrefix (List<Transaction> transactions) {
        return transactions.stream().map(x->x.getTrader().getName()).collect(Collectors.joining(", Trader Name : "));
    }



    // Test Group by

    public Map<String , List<Transaction>> listTxGroupByName (List<Transaction> transactions) {
        return transactions.stream()
                .collect(Collectors.groupingBy(x-> x.getTrader().getName()));
    }

    public Map<String , List<Transaction>> groupByWithCustomKey (List<Transaction> transactions) {
        return transactions.stream()
                .collect(Collectors.groupingBy(x-> {
                    if (x.getValue() <= 0) return "Profit-0";
                    else if (x.getValue() <=500) return "Profit-Up";
                    else if (x.getValue() <= 1000) return "Profit-High";
                    else return "Profit-Cloud";
                }));
    }

    public Map<String, Map<Integer, List<Transaction>>> nestGroupBy (List<Transaction> transactions) {

        return transactions.stream().collect(Collectors
                .groupingBy(x->
                        x.getTrader().getName(), Collectors
                        .groupingBy(Transaction::getYear)
                )
        );
    }



    // Test Sub-group by
    public Map<String, Long> groupBySubGroups (List<Transaction> transactions) {
        return transactions.stream()
                .collect(Collectors.groupingBy(x-> x.getTrader().getName(), Collectors.counting()));
    }

    public Map<Integer, Transaction> groupByYearAndGetTopValue (List<Transaction> transactions) {

        Map<Integer, Transaction>  style1 = transactions.stream().collect(
                Collectors.groupingBy(Transaction::getYear,
                        Collectors.collectingAndThen(
                                Collectors.maxBy(
                                        Comparator.comparing(Transaction::getValue)
                                ), Optional::get
                        )
                )
        );

        Map<Integer, Transaction>  style2 = transactions.stream().collect(
                Collectors.toMap(Transaction::getYear, Function.identity(), BinaryOperator.maxBy(Comparator.comparing(Transaction::getValue)))
        );


        return style1;
    }




    // Test Partitioning : group list by boolean field
    public Map<Boolean, List<Transaction>> partitioningByValue (List<Transaction> transactions) {
        return transactions.stream().collect(Collectors.partitioningBy(Transaction::isExpansive));
    }

    public Map<Boolean, Map<Integer, List<Transaction>>> partitioningWithGrouping (List<Transaction> transactions) {
        return transactions.stream().collect(Collectors.partitioningBy(Transaction::isExpansive, Collectors.groupingBy(Transaction::getYear)));
    }




    //##########################################################################################
    /**
     * Question -> solutions
     *
     * @return
     */

    public Map<Integer, List<Transaction>> q1(List<Transaction> transactions) {
        return transactions.stream()
                .collect(Collectors.groupingBy(Transaction::getYear));
    }


    public Map<Boolean, List<Transaction>> q2(List<Transaction> transactions) {
        var style1 =  transactions.stream().collect(Collectors.groupingBy(x-> {
            if (x.getValue() <500)
                return true;
            else
                return false;
        }));

        var style2 =  transactions.stream()
                .collect(Collectors.partitioningBy(x->x.getValue() <500));

        return style1;
    }

    public Map<EconomicClass, Map<Integer, List<Transaction>>> q3(List<Transaction> transactions) {

        return transactions.stream()
                .peek(x-> System.out.println("I'm x "+x)) // this peek() do only print x it not transform anything // peek is a non-terminal
                .collect(
                        Collectors.groupingBy(x -> x.getTrader().getEconomicClass(),
                        Collectors.groupingBy(Transaction::getYear))
                );
    }
}

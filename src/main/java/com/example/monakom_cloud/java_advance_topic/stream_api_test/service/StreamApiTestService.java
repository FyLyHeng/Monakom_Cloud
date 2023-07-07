package com.example.monakom_cloud.java_advance_topic.stream_api_test.service;

import com.example.monakom_cloud.java_advance_topic.ObjectTest;
import com.example.monakom_cloud.java_advance_topic.stream_api_test.model.EconomicClass;
import com.example.monakom_cloud.java_advance_topic.stream_api_test.model.Trader;
import com.example.monakom_cloud.java_advance_topic.stream_api_test.model.Transaction;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@Slf4j
public class StreamApiTestService {


    Trader liza = new Trader("liza","PP", EconomicClass.WEALTHY);
    Trader bopha = new Trader("bopha","Sim reap", EconomicClass.SUPERSEDED_CLASS);
    Trader rachna = new Trader("rachna","Sim reap", EconomicClass.MINDED_CLASS);
    Trader heng = new Trader("heng","YK", EconomicClass.SUPERSEDED_CLASS);

    List<Transaction> transactions = Arrays.asList(
            new Transaction(2012, 100.20,liza),
            new Transaction(2011, 300,liza),
            new Transaction(2013, 1000,bopha),
            new Transaction(2011, 500,rachna),
            new Transaction(2020, 650.10,heng),
            new Transaction(2023, 700,heng)
    );

    public List<Transaction> getAllTransaction () {
        return transactions;
    }


    public List<String> listAllAndSelectCity(List<Transaction> transactions) {
        return transactions.stream()
                .map(x-> x.getTrader().getCity())
                .distinct()
                .collect(Collectors.toList());
    }


    public List<Trader> findAllByCityAndSelectTrader(List<Transaction> transactions) {
        return transactions.stream()
                .map(Transaction::getTrader)
                .filter(trader -> Objects.equals(trader.getCity(), "PP"))
                .sorted(Comparator.comparing(Trader::getName))
                .collect(Collectors.toList());
    }


    void test1() {

        List<ObjectTest> cars = Arrays.asList(
                new ObjectTest(1000, "BMW"),
                new ObjectTest(1000, "Honda"),
                new ObjectTest(1000, "Audi")
        );

        List<Integer> carNameLength = cars.stream()
                .map(ObjectTest::getBrand)
                .map(String::length)
                .collect(Collectors.toList());
    }

    void test2() throws Exception {

        List<Integer> numbers = Arrays.asList(1,2,3,4,5);

        var result = numbers.stream()
                .map(n-> n*n)
                .collect(Collectors.toList());

        Integer r1 = numbers.stream().filter(a->a==1).findFirst().orElseThrow();
        Integer r2 = numbers.stream().filter(a->a==1).findFirst().orElseThrow(Exception::new); // = new Exception();
        Integer r3 = numbers.stream().filter(a->a==1).findFirst().orElseThrow(() -> new Exception("filter r1 not found"));
    }



    public String test4 (List<Transaction> transactions) {
        return transactions.stream()
                .map(x->x.getTrader().getName())
                .distinct()
                .sorted()
                .reduce("", (a,b)-> a + b + " "); //join string.name
    }

    public Boolean test5 (List<Transaction> transactions) {
        return transactions.stream().anyMatch(x-> Objects.equals(x.getTrader().getCity(), "PP"));
    }

    public Integer test6 (List<Transaction> transactions) {
        Integer style1 = transactions.stream()
                .map(Transaction::getYear)
                .reduce(Integer::max) // return the high value
                .orElse(-1);    // else return -1



        Integer style2 =  transactions.stream()
                .map(Transaction::getYear)
                .reduce(-1,Integer::max); // return the high value , else return -1


        return style2;
    }


    public Transaction getByBiggestTrxValue (List<Transaction> transactions) {
        return transactions.stream()
                .reduce((a,b) ->

                        a.getYear() < b.getYear() ? a : b

                ).orElse(new Transaction(1700, 0, new Trader("N/A","N/A", EconomicClass.N_A)));
    }


}

package com.example.monakom_cloud.java_advance_topic.stream_test;

import com.example.monakom_cloud.dto.TransactionDTO;
import com.example.monakom_cloud.java_advance_topic.stream_test.EconomicClass;
import com.example.monakom_cloud.java_advance_topic.stream_test.Trader;
import com.example.monakom_cloud.java_advance_topic.stream_test.Transaction;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
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
@Mapper(componentModel = "spring")
@Qualifier("v1")
@Primary
public abstract class StreamApiTestService {


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


    public List<TransactionDTO> test1(List<Transaction> transactions) {

        List<TransactionDTO> result = transactions.stream()
                .filter(x -> 2011 == x.getYear() && Objects.equals("liza", x.getTrader().getName()))
                .sorted(Comparator.comparing(Transaction::getValue))
                //.map(TransactionMapper.INSTANCE::convert)
                .map(this::convert)
                .collect(Collectors.toList());

        log.info(result.toString());


        return result;
    }

    @Mapping(target = "traderName", source="trader.name")
    public abstract TransactionDTO convert(Transaction transaction);



    public List<String> test2 (List<Transaction> transactions) {
        return transactions.stream()
                .map(x-> x.getTrader().getCity())
                .distinct()
                .collect(Collectors.toList());
    }


    public List<Trader> test3 (List<Transaction> transactions) {
        return transactions.stream()
                .map(Transaction::getTrader)
                .filter(trader -> Objects.equals(trader.getCity(), "PP"))
                .sorted(Comparator.comparing(Trader::getName))
                .collect(Collectors.toList());
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

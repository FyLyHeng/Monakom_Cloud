package com.example.monakom_cloud.java_advance_topic.map_struct_test;

import com.example.monakom_cloud.java_advance_topic.stream_api_test.model.Transaction;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Qualifier("v1")
@Service
@Slf4j
@Mapper(componentModel = "spring")
@Primary
public abstract class MapStructTestService {

    public List<TransactionDTO> findAllByYearAndName(List<Transaction> transactions) {

        List<TransactionDTO> result = transactions.stream()
                .filter(x -> 2011 == x.getYear() && Objects.equals("liza", x.getTrader().getName()))
                .sorted(Comparator.comparing(Transaction::getValue))
                //.map(TransactionMapper.INSTANCE::convert)
                .map(this::convert)
                .collect(Collectors.toList());

        log.info(result.toString());


        return result;
    }


    public List<TransactionDTO> findAllByYearAndName01(List<Transaction> transactions) {

        List<TransactionDTO> result = transactions.stream()
                .filter(x -> 2011 == x.getYear() && Objects.equals("liza", x.getTrader().getName()))
                .sorted(Comparator.comparing(Transaction::getValue))
                .map(TransactionMapper.INSTANCE::convert)
                .collect(Collectors.toList());

        log.info(result.toString());


        return result;
    }

    @Mapping(target = "traderName", source="trader.name")
    public abstract TransactionDTO convert(Transaction transaction);
}

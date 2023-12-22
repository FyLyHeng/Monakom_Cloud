package com.example.monakom_cloud.java_feature_8_17.java8.map_struct_test;

import com.example.monakom_cloud.java_feature_8_17.java8.stream_api_test.model.Transaction;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper()
public interface TransactionMapper {
    TransactionMapper INSTANCE = Mappers.getMapper(TransactionMapper.class);
    @Mapping(target="traderName", source="trader.name")
    TransactionDTO convert(Transaction transaction);
}
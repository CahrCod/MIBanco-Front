package com.udea.mibanco.mapper;

import com.udea.mibanco.DTO.TransactionDTO;
import com.udea.mibanco.entity.Transaction;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")

public interface TransactionMapper
{
    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);
    TransactionDTO toDTO(Transaction transaction);
    Transaction toEntity(TransactionDTO transactionDTO);
}

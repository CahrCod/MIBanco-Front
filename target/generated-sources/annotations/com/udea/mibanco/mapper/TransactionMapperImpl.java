package com.udea.mibanco.mapper;

import com.udea.mibanco.DTO.TransactionDTO;
import com.udea.mibanco.entity.Transaction;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-04-12T15:59:05-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.12 (Oracle Corporation)"
)
@Component
public class TransactionMapperImpl implements TransactionMapper {

    @Override
    public TransactionDTO toDTO(Transaction transaction) {
        if ( transaction == null ) {
            return null;
        }

        TransactionDTO transactionDTO = new TransactionDTO();

        transactionDTO.setId( transaction.getId() );
        transactionDTO.setSenderAccountNumber( transaction.getSenderAccountNumber() );
        transactionDTO.setReceiverAccountNumber( transaction.getReceiverAccountNumber() );
        transactionDTO.setAmount( transaction.getAmount() );
        transactionDTO.setTimestamp( transaction.getTimestamp() );

        return transactionDTO;
    }

    @Override
    public Transaction toEntity(TransactionDTO transactionDTO) {
        if ( transactionDTO == null ) {
            return null;
        }

        Transaction transaction = new Transaction();

        transaction.setId( transactionDTO.getId() );
        transaction.setSenderAccountNumber( transactionDTO.getSenderAccountNumber() );
        transaction.setReceiverAccountNumber( transactionDTO.getReceiverAccountNumber() );
        transaction.setAmount( transactionDTO.getAmount() );
        transaction.setTimestamp( transactionDTO.getTimestamp() );

        return transaction;
    }
}

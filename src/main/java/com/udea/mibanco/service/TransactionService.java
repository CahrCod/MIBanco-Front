package com.udea.mibanco.service;

import com.udea.mibanco.DTO.TransactionDTO;
import com.udea.mibanco.entity.Customer;
import com.udea.mibanco.entity.Transaction;
import com.udea.mibanco.repository.CustomerRepository;
import com.udea.mibanco.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransactionService
{
    @Autowired // Otra forma de inyectar las dependecias a través de atributos
    private final TransactionRepository transactionRepository;

    @Autowired
    private final CustomerRepository customerRepository;

    public TransactionService(TransactionRepository transactionRepository,
                              CustomerRepository customerRepository)
    {
        this.transactionRepository = transactionRepository;
        this.customerRepository = customerRepository;
    }

    public TransactionDTO transferMoney(TransactionDTO transactionDTO)
    {
        if (transactionDTO.getSenderAccountNumber() == null
                || transactionDTO.getReceiverAccountNumber() == null)
        {
            throw new IllegalArgumentException(
                    "Sender or Receiver account number cannot be null");
        }

        Customer sender = customerRepository.findByAccountNumber(
                        transactionDTO.getSenderAccountNumber())
                .orElseThrow(() -> new IllegalArgumentException(
                        "Sender account number  does not exist"));

        Customer receiver = customerRepository.findByAccountNumber(
                        transactionDTO.getReceiverAccountNumber())
                .orElseThrow(() -> new IllegalArgumentException(
                        "receiver account number  does not exist"));

        if (sender.getBalance() < transactionDTO.getAmount())
        {
            throw new IllegalArgumentException("Sender Balance does not enough");
        }


        sender.setBalance(sender.getBalance() - transactionDTO.getAmount());
        receiver.setBalance(receiver.getBalance() + transactionDTO.getAmount());

        customerRepository.save(sender);
        customerRepository.save(receiver);

        Transaction transaction = new Transaction();
        transaction.setSenderAccountNumber(sender.getAccountNumber());
        transaction.setReceiverAccountNumber(receiver.getAccountNumber());
        transaction.setAmount(transactionDTO.getAmount());
        transaction.setTimestamp(transactionDTO.getTimestamp());
        transaction = transactionRepository.save(transaction);

        TransactionDTO savedTransaction = new TransactionDTO();
        savedTransaction.setId(transaction.getId());
        savedTransaction.setSenderAccountNumber(sender.getAccountNumber());
        savedTransaction.setReceiverAccountNumber(receiver.getAccountNumber());
        savedTransaction.setAmount(transactionDTO.getAmount());
        savedTransaction.setTimestamp(transactionDTO.getTimestamp());
        return savedTransaction;

    }

    public List<TransactionDTO> getTransactionsForAccount(String accountNumber)
    {
        List<Transaction> transactions= transactionRepository
                   .findBySenderAccountNumberOrReceiverAccountNumber(accountNumber,accountNumber);
        return transactions.stream().map(transaction -> {
            TransactionDTO dto = new TransactionDTO();
            dto.setId(transaction.getId());
            dto.setSenderAccountNumber(transaction.getSenderAccountNumber());
            dto.setReceiverAccountNumber(transaction.getReceiverAccountNumber());
            dto.setAmount(transaction.getAmount());
            dto.setTimestamp(transaction.getTimestamp());
            return dto;
        }).collect(Collectors.toList());
    }

}

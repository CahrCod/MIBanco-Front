package com.udea.mibanco.controller;

import com.udea.mibanco.DTO.TransactionDTO;
import com.udea.mibanco.service.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:5173")
@RequestMapping("/api/transaction")
public class TransactionController
{
    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService)
    {
        this.transactionService = transactionService;
    }

    @PostMapping
    public ResponseEntity<TransactionDTO> transferMoney(@RequestBody TransactionDTO transactionDTO)
    {
        if((transactionDTO.getSenderAccountNumber().equals(transactionDTO.getReceiverAccountNumber())))
        {
            throw new IllegalArgumentException("SenderAccountNumber can't be the same");
        }

        return ResponseEntity.ok(transactionService.transferMoney(transactionDTO));
    }

    @GetMapping("/{accountNumber}")
    public ResponseEntity<List<TransactionDTO>> getTransactionsForAccount(
            @PathVariable String accountNumber)
    {
        return ResponseEntity.ok(transactionService.getTransactionsForAccount(accountNumber));
    }
}

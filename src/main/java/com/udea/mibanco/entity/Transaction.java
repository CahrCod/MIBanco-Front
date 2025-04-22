package com.udea.mibanco.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name="transactions")
@Data
@Getter
@Setter

public class Transaction
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String senderAccountNumber;
    @Column(nullable = false)
    private String receiverAccountNumber;
    @Column(nullable = false)
    private Double amount;
    @Column(nullable = false)
    private LocalDateTime timestamp;

    @JsonCreator
    public Transaction(
            @JsonProperty("id") Long id,
            @JsonProperty("senderAccountNumber") String senderAccountNumber,
            @JsonProperty("receiverSenderAccountNumber") String receiverAccountNumber,
            @JsonProperty("amount") Double amount,
            @JsonProperty("timestamp") LocalDateTime timestamp)
    {
        this.id = id;
        this.senderAccountNumber = senderAccountNumber;
        this.receiverAccountNumber = receiverAccountNumber;
        this.amount = amount;
        this.timestamp = timestamp;
    }

    public Transaction() {}
}

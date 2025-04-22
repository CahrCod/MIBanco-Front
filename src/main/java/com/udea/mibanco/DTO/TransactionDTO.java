package com.udea.mibanco.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Column;
import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@JsonInclude(JsonInclude.Include.NON_NULL)

public class TransactionDTO
{
    private Long id;
    private String senderAccountNumber;
    private String receiverAccountNumber;
    private Double amount;
    private LocalDateTime timestamp;
}

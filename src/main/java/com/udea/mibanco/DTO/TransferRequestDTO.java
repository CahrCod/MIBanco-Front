package com.udea.mibanco.DTO;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class TransferRequestDTO
{
    private String senderAccountNumber;
    private String receiverAccountNumber;
    private Double amount;
}

package com.udea.mibanco.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Column;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@JsonInclude(JsonInclude.Include.NON_NULL)

public class CustomerDTO
{
    private Long id;
    private String accountNumber;
    private String firstName;
    private String lastName;
    private Double balance;
}

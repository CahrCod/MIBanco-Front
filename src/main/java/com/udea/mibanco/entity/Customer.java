package com.udea.mibanco.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="customers")
@Data
@Getter
@Setter

public class Customer
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique=true, nullable = false)
    private String accountNumber;
    @Column(nullable = false, length = 50)
    private String firstName;
    @Column(nullable = false, length = 50)
    private String lastName;
    @Column(nullable = false)
    private Double balance;

    @JsonCreator
    public Customer(
            @JsonProperty("i") Long id,
            @JsonProperty("accountNumber") String accountNumber,
            @JsonProperty("accountNumber") String firstName,
            @JsonProperty("lastName") String lastName,
            @JsonProperty("balance") Double balance)
    {
        this.id = id;
        this.accountNumber = accountNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.balance = balance;
    }

    public Customer() {

    }
}

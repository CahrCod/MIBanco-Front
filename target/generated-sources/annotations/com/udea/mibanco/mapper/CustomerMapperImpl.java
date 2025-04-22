package com.udea.mibanco.mapper;

import com.udea.mibanco.DTO.CustomerDTO;
import com.udea.mibanco.entity.Customer;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-04-12T15:59:05-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.12 (Oracle Corporation)"
)
@Component
public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public CustomerDTO toDTO(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        CustomerDTO customerDTO = new CustomerDTO();

        customerDTO.setId( customer.getId() );
        customerDTO.setAccountNumber( customer.getAccountNumber() );
        customerDTO.setFirstName( customer.getFirstName() );
        customerDTO.setLastName( customer.getLastName() );
        customerDTO.setBalance( customer.getBalance() );

        return customerDTO;
    }

    @Override
    public Customer toEntity(CustomerDTO customerDTO) {
        if ( customerDTO == null ) {
            return null;
        }

        Customer customer = new Customer();

        customer.setId( customerDTO.getId() );
        customer.setAccountNumber( customerDTO.getAccountNumber() );
        customer.setFirstName( customerDTO.getFirstName() );
        customer.setLastName( customerDTO.getLastName() );
        customer.setBalance( customerDTO.getBalance() );

        return customer;
    }
}

package com.udea.mibanco.controller;

import com.udea.mibanco.DTO.CustomerDTO;
import com.udea.mibanco.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:5173")
@RequestMapping("/api/customers")
public class CustomerController
{
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService)
    {
        this.customerService = customerService;
    }

    @GetMapping
    public ResponseEntity<List<CustomerDTO>> getAllCustomer()
    {
        return ResponseEntity.ok(customerService.getAllCustomers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable Long id)
    {
        return ResponseEntity.ok(customerService.getCustomerById(id));
    }

    @PostMapping
    public ResponseEntity<CustomerDTO> createCustomer(@RequestBody CustomerDTO customerDTO)
    {
        if(customerDTO.getBalance() == null || customerDTO.getBalance() < 0)
        {
            throw new IllegalArgumentException("Balance cannot null or negative");
        }
        return ResponseEntity.ok(customerService.createCustomer(customerDTO));
    }

}

package com.example.drawerfamex.backend.models.customers;

import com.example.drawerfamex.backend.models.customers.Customer;

import lombok.Data;

@Data

public class MessageCustomer {
    private Boolean newCustomer;//"true"
    private Customer customer;
}

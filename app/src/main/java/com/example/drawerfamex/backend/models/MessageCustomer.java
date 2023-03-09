package com.example.drawerfamex.backend.models;

import com.example.drawerfamex.backend.models.customers.Customer;

import lombok.Data;

@Data

public class MessageCustomer {
    private Boolean newCustomer;//"true"
    private Customer customer;
}

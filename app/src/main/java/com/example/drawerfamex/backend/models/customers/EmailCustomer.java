package com.example.drawerfamex.backend.models.customers;

import lombok.Data;

@Data
public class EmailCustomer {
    private String idEmail; // "",
    private String email; //"mauricio.mendoza@adira.com.mx",
    private Boolean principal; //true
    private Boolean active; //true
}

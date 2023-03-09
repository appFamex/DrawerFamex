package com.example.drawerfamex.backend.models.customers;

import lombok.Data;

@Data
public class PhoneCustomer {
    private String idPhone; //"",
    private String number; //"5521076350",
    private String extension; //"",
    private Boolean principal; //true o false
    private Boolean active; //true o false
}

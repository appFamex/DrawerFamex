package com.example.drawerfamex.backend.models.customers.invoiceinfo;

import lombok.Data;

@Data
public class PhoneInvoiceInfo {
    private String idPhone; //"",
    private String number; //"5521076350",
    private String extension; //"",
    private Boolean principal; //true o false
    private Boolean active; //true o false
}

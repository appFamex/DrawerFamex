package com.example.drawerfamex.backend.models.customers.invoiceinfo;

import com.example.drawerfamex.backend.models.customers.invoiceinfo.AddressInvoiceInfo;
import com.example.drawerfamex.backend.models.customers.invoiceinfo.EmailInvoiceInfo;
import com.example.drawerfamex.backend.models.customers.invoiceinfo.PhoneInvoiceInfo;

import lombok.Data;

@Data
public class InvoiceInfo {
    private String idInvoiceInfo; // "0",
    private String name; // Jorge Ignacio Abel Canche Cauich",
    private String taxId; // "HEPC8203154P0",
    //email
    private EmailInvoiceInfo email;
    //phone
    private PhoneInvoiceInfo phone;
    //address
    private AddressInvoiceInfo address;

}

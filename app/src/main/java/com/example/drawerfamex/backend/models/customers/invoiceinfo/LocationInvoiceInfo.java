package com.example.drawerfamex.backend.models.customers.invoiceinfo;

import com.example.drawerfamex.backend.models.customers.invoiceinfo.CityInvoiceInfo;
import com.example.drawerfamex.backend.models.customers.invoiceinfo.CountryInvoiceInfo;
import com.example.drawerfamex.backend.models.customers.invoiceinfo.StateInvoiceInfo;

import lombok.Data;

@Data
public class LocationInvoiceInfo {
    private String idLocation; // "45648",
    private String postalCode; // "97302",
    private String locationName; // "Merida, Yucatán",
    //city
    private CityInvoiceInfo city;
    //State
    private StateInvoiceInfo state;
    //country
    private CountryInvoiceInfo country;
}

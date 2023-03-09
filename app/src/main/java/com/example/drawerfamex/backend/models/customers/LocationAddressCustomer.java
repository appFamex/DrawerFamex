package com.example.drawerfamex.backend.models.customers;

import lombok.Data;

@Data
public class LocationAddressCustomer {
    private String idLocation; // "45648",
    private String postalCode; // "97302",
    private String locationName; // "Merida, Yucatán",
    //city
    private CityAddressCustomer city;
    //State
    private StateAddressCustomer state;
    //country
    private CountryAddressCustomer country;
}

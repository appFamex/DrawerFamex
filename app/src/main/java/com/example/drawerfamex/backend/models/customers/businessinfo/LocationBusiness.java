package com.example.drawerfamex.backend.models.customers.businessinfo;

import lombok.Data;

@Data
public class LocationBusiness {
    private String idLocation; // "45648",
    private String postalCode; // "97302",
    private String locationName; // "Merida, Yucatán",
    //City
    private CityAddressBusiness city;
    //State
    private StateAddressBusiness state;
    //Country
    private CountryAddressBusiness country;
}

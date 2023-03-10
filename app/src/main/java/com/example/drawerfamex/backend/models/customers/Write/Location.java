package com.example.drawerfamex.backend.models.customers.Write;

import lombok.Data;

@Data
public class Location {

    private String idLocation; //": "45648",
    private String postalCode; //": "55715",

    private City city;
    private State state;
    private Country country;
}

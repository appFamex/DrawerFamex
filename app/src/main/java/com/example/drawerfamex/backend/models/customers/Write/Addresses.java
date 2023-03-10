package com.example.drawerfamex.backend.models.customers.Write;

import lombok.Data;

@Data
public class Addresses {

    private String idAddress; //": "60955f22bcdc590001e47f3f",
    private Boolean principal; //": true,
    private String street;//": "Eje 8",
    private String numberInt; //": "24",
    private String numberExt; //": "8",

    private Boolean active; //": true,
    private Boolean deliverCard; //": false,
    private String latitude; // ": "10.2346",
    private String longitude; //: "-12.0001"


    //
    private Location location;

}

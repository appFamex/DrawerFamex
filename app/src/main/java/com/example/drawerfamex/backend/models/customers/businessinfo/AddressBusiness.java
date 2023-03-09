package com.example.drawerfamex.backend.models.customers.businessinfo;

import lombok.Data;

@Data
public class AddressBusiness {
    private String idAddress; // "",
    private Boolean principal; // true
    private String street; // "19",
    private String numberInt; // "0",
    private String numberExt; // "0",
    private Boolean active; // true,
    private Boolean deliverCard; // false,
    private String latitude; // "10.2346",
    private String longitude; // "-12.0001",
    //Location
    private LocationBusiness location;
}

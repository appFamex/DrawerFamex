package com.example.drawerfamex.backend.models.customers.businessinfo;

import lombok.Data;

@Data
public class BusinessInfo {
    private Boolean active; // true,
    private String idBusinessInfo; // "0",
    private String nameBusiness; // "Tiendita 1",
    //ExtendedAttributes
    private ExtendedAttributesBusinessInfo extendedAttributes;
    //CoreBusiness
    private CoreBusiness coreBusiness;
    //Address
    private AddressBusiness address;
}

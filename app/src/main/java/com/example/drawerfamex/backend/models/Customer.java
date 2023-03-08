package com.example.drawerfamex.backend.models;

import android.text.format.DateFormat;

import lombok.Data;

@Data
public class Customer {

    private Boolean newCustomer;//"true"
    //customer":
    private String segment; //"x",
    private String idUser; // "121212",
    private String userId; //"1212",
    private String firstName; //"Mauricio",
    private String lastName; //"Mendoza",
    private String motherMaidenName; //"Mendoza",
    private DateFormat birthDate; //"21/10/1997",
    private Boolean active; //true,
    private int idOccupation; // 1,
    private int idEconomicActivity; // "1",
    private String gender;// "H",
    private String expirationId; //"",
    private String numberId; // "",
    private String countryOfIssue; //"",
    private String nationality; //"MX",
    private String birthState; //"MX",
    private String photo;// "",
    //emails;
    private String idEmail; //"",
    private String email; //"mauricio.mendoza@adira.com.mx"

}

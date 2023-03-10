package com.example.drawerfamex.backend.models.customers.Write;

import java.util.List;

import lombok.Data;

@Data
public class update_customer {

    private Boolean newCustomer;//": false,
            //"customer;//": {
    private String idCustomer;//": "60955f1ebcdc590001e47f3e",
    private String segment;//": "x",
    private String photo;//": "",


    private String firstName; // ": "Carlos Alberto",
    private String motherMaidenName; //": "Pantoja",
    private String lastName; //": "Herrera",
    private String birthDate; //": "15/03/1982",
    private String active; //": false,
    private String tip; //": false,
    private String idOccupation; //": "1",
    private String gender; //": "H",
    private String expirationId; //": "",
    private String countryOfIssue; //": "",
    private String nationality; //": "MX"

    ///
    //emails
    private List<Emails> emails;
    //phones
    private List<Phones> phones;
    //adresses
    private List<Addresses> addresses;



}

package com.example.drawerfamex.backend.models.customers;

import android.text.format.DateFormat;

import com.example.drawerfamex.backend.models.customers.businessinfo.BusinessInfo;
import com.example.drawerfamex.backend.models.customers.invoiceinfo.InvoiceInfo;

import java.util.List;

import lombok.Data;

@Data
public class Customer {


    //customer":
    private String segment; //"x",
    private String idUser; // "121212",
    private String userId; //"1212",
    private String firstName; //"Mauricio",
    private String lastName; //"Mendoza",
    private String motherMaidenName; //"Mendoza",
    private DateFormat birthDate; //"21/10/1997",
    private Boolean active; //true,
    private Integer idOccupation; // 1,
    private Integer idEconomicActivity; // "1",
    private String gender;// "H",
    private String expirationId; //"",
    private String numberId; // "",
    private String countryOfIssue; //"",
    private String nationality; //"MX",
    private String birthState; //"MX",
    private String photo;// "",
    //emails
    private List<EmailCustomer> emails;
    //phones
    private List<PhoneCustomer> phones;
    //adresses
    private List<AddressCustomer> adresses;
    //invoiceInfo
    private InvoiceInfo invoiceinfo;
    //businessInfo
    private BusinessInfo businessInfo;




}

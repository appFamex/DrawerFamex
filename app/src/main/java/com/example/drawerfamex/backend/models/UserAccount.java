package com.example.drawerfamex.backend.models;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;

@Data
public class UserAccount {
    private Integer id;
    private String idSecurity;
    private String idCustomer;
    private Integer appNameId;
    private String clabe;
    private BigDecimal dispersions;
    private BigDecimal withdrawals;
    private String name;
    private String lastName;
    private String secondLastName;
    private Date birthDay;
    private BigDecimal balance;
}

package com.example.drawerfamex.backend.models;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class User {
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private Date lastSession;
    private String accessToken;
    private String refreshToken;
    private String password;
    private List<Role> roles;

}

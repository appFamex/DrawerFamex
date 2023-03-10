package com.example.drawerfamex.backend.models.login;


import com.example.drawerfamex.backend.models.Message;
import com.google.gson.Gson;

import lombok.Data;

import java.util.List;

@Data
public class MessageLogin extends Message {

    public Boolean newCustomer;
    public Boolean getPicture;
    public String user;
    public List<User> users;
    public UserAccount account;
    public List<User> refreshToken;

    public String toJson() {
        return new Gson().toJson(this);
    }

    public static MessageLogin fromJson(String payload) {
        return new Gson().fromJson(payload, MessageLogin.class);
    }
}

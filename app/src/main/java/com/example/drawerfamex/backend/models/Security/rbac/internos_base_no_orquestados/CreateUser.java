package com.example.drawerfamex.backend.models.Security.rbac.internos_base_no_orquestados;

import com.example.drawerfamex.backend.models.login.Role;

import java.util.List;

import lombok.Data;

@Data
public class CreateUser {
    private String username; // "test_donde3@gmail.com",
    private String password; // "!QAZ2wsx",
    private String firstName; // "test",
    private String lastName; // "test",
    private String email; // "test_donde3@gmail.com",
    //Role
    private List<Role> roles;
}

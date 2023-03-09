package com.example.drawerfamex.backend.models.Security.rbac.internos_base_no_orquestados.find;

import java.util.List;

import lombok.Data;

@Data
public class User {
    private String username; // "test_donde3@gmail.com",
    private String password; // "!QAZ2wsx",
    private String firstName; // "test",
    private String lastName; // "test",
    private String email; // "test_donde3@gmail.com",
    //Rol
    private List<Rol> roles;
}

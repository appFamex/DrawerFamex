package com.example.drawerfamex.backend.models.Security.rbac;

import com.example.drawerfamex.backend.models.Security.rbac.internos_base_no_orquestados.CreateUser;
import com.example.drawerfamex.backend.models.Security.rbac.internos_base_no_orquestados.UpdateUser;

import java.util.List;

import lombok.Data;

@Data
public class MessageUser {
    private Boolean newUser;
    private List<CreateUser> createUser;
    private List<UpdateUser> updateUser;
}

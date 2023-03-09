package com.example.drawerfamex.backend.models.login;

import com.example.drawerfamex.backend.models.MessageError;

import lombok.Data;

import java.util.List;

@Data
public class StatusOperation {

    private Integer status;

    private String description;

    private List<MessageError> errors;

}

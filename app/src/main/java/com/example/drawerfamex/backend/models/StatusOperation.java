package com.example.drawerfamex.backend.models;

import lombok.Data;

import java.util.List;

@Data
public class StatusOperation {

    private Integer status;

    private String description;

    private List<MessageError> errors;

}

package com.example.drawerfamex.backend.utils;

import lombok.Data;

@Data
public class FamexException extends Exception {

    private String description;
    private String module;
    private Integer code;

    public FamexException(String description, String module, Integer code) {
        super(description);
    }

}

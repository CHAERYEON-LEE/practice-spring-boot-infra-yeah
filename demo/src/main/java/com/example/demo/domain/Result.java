package com.example.demo.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Result {
    private String code;
    private String message;
    private Object data;
}

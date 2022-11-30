package com.example.todoapp.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

public class BaseResponse {
    private int code;
    private String message;
    public BaseResponse(){
        this.code = 1;
        this.message = "SUCCESS";
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

package com.example.todoapp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.example.todoapp.entity.BaseResponse;

public class BaseController {
    public ResponseEntity<BaseResponse> createdResponse(BaseResponse response){
        return new ResponseEntity<>(response , HttpStatus.ACCEPTED);
    }
    public ResponseEntity<BaseResponse> createdResponse(BaseResponse response, HttpStatus httpStatus){
        return new ResponseEntity<>(response , httpStatus);
    }
}

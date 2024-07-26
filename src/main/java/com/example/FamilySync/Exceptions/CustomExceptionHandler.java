package com.example.FamilySync.Exceptions;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter@Setter
public class CustomExceptionHandler extends RuntimeException{
    private HttpStatus status;
    public CustomExceptionHandler(String email, HttpStatus status){
        super(String.format("Exception in creating OTP for email %s",email));
        this.status=status;
    }
}

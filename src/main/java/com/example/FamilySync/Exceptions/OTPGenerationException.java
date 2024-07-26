package com.example.FamilySync.Exceptions;

public class OTPGenerationException extends RuntimeException {
    public OTPGenerationException(String email) {
        super(String.format("Exception in creating OTP for email %s",email));
    }
}

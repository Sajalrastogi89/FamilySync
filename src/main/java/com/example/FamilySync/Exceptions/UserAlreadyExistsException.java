package com.example.FamilySync.Exceptions;

public class UserAlreadyExistsException extends RuntimeException {
    public UserAlreadyExistsException(String email) {
        super(String.format("%s already exists",email));
    }
}

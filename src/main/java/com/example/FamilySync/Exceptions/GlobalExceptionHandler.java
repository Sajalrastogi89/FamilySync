package com.example.FamilySync.Exceptions;

import com.example.FamilySync.DTO.responseDTO.ApiResponseWithoutObjectDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<ApiResponseWithoutObjectDTO> userAlreadyExistsException(UserAlreadyExistsException ex){
       return new ResponseEntity<>(new ApiResponseWithoutObjectDTO(ex.getMessage(),false), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(OTPGenerationException.class)
    public ResponseEntity<ApiResponseWithoutObjectDTO> otpGenerationException(OTPGenerationException ex){
        return new ResponseEntity<>(new ApiResponseWithoutObjectDTO(ex.getMessage(),false),HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ApiResponseWithoutObjectDTO> runtimeException(RuntimeException ex){
        return new ResponseEntity<>(new ApiResponseWithoutObjectDTO(ex.getMessage(),false),HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CustomExceptionHandler.class)
    public ResponseEntity<ApiResponseWithoutObjectDTO> customExceptionHandler(CustomExceptionHandler ex){
        return new ResponseEntity<>(new ApiResponseWithoutObjectDTO(ex.getMessage(),false),ex.getStatus());
    }



}

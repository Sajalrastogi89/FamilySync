package com.example.FamilySync.Exceptions;

import com.example.FamilySync.DTO.GetApiResponseDTO;
import com.example.FamilySync.DTO.PostApiResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<PostApiResponseDTO> userAlreadyExistsException(UserAlreadyExistsException ex){
       return new ResponseEntity<>(new PostApiResponseDTO(ex.getMessage(),false), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<PostApiResponseDTO> runtimeException(RuntimeException ex){
        return new ResponseEntity<>(new PostApiResponseDTO(ex.getMessage(),false),HttpStatus.BAD_REQUEST);
    }

}

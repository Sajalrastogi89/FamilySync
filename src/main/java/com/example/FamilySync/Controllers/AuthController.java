package com.example.FamilySync.Controllers;

import com.example.FamilySync.DTO.GetApiResponseDTO;
import com.example.FamilySync.DTO.PostApiResponseDTO;
import com.example.FamilySync.DTO.UserDTO;
import com.example.FamilySync.Exceptions.UserAlreadyExistsException;
import com.example.FamilySync.Models.User;
import com.example.FamilySync.Services.AuthService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {


    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    // Register User
    @PostMapping("/register")
    public ResponseEntity<PostApiResponseDTO> register(@Valid @RequestBody UserDTO userDTO){
        //convert userDTO to user
        User user=authService.DtoToUser(userDTO);
        // check user Already exists
        boolean exists=authService.checkUser(user.getEmail());
        // if (true) -> throw user already exists exception
        if(exists){
            throw new UserAlreadyExistsException(user.getEmail());
        }
        // else -> register user
        authService.registerUser(user);
        return new ResponseEntity<>(new PostApiResponseDTO("User created successfully", true), HttpStatus.CREATED);
    }

    //Login user



    // OTP send



    // OTP verification



    // Forgot Password (Create totally new password)




    // verify email



    // change password ( Using old password )



}

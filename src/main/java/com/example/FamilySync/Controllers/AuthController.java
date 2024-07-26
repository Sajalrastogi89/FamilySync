package com.example.FamilySync.Controllers;

import com.example.FamilySync.DTO.responseDTO.ApiResponseWithObjectDTO;
import com.example.FamilySync.DTO.responseDTO.ApiResponseWithoutObjectDTO;
import com.example.FamilySync.DTO.requestDTO.UserDTO;
import com.example.FamilySync.Exceptions.CustomExceptionHandler;
import com.example.FamilySync.Exceptions.OTPGenerationException;
import com.example.FamilySync.Exceptions.UserAlreadyExistsException;
import com.example.FamilySync.Models.User;
import com.example.FamilySync.Services.AuthService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/auth")
public class AuthController {


    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    // Register User
    @PostMapping("/register")
    public ResponseEntity<ApiResponseWithoutObjectDTO> register(@Valid @RequestBody UserDTO userDTO){
        try {
            //convert userDTO to user
            User user = authService.DtoToUser(userDTO);
            // check user Already exists
            boolean exists = authService.checkUser(user.getEmail());
            // if (true) -> throw user already exists exception
            if (exists) {
                throw new CustomExceptionHandler(String.format("%s already exists", user.getEmail()),HttpStatus.BAD_REQUEST);
            }
            // else -> register user
            authService.registerUser(user);
            return new ResponseEntity<>(new ApiResponseWithoutObjectDTO("User created successfully", true), HttpStatus.CREATED);
        }
        catch (CustomExceptionHandler e){
            throw e;
        }
        catch (RuntimeException e) {
            throw new RuntimeException("Exception in registering user");
        }



        }

    //Login user



    // OTP send
    @PostMapping("/generateOTP/{email}")
    public ResponseEntity<ApiResponseWithObjectDTO<?>> generateOTP(@PathVariable String email){
        try {
            // generate otp
            String Otp = authService.generateRandomOTP();
            LocalDateTime expiresAt = LocalDateTime.now().plusMinutes(10);
            //add in database with expiry date
            authService.storeOtpAndExpiry(email,Otp,expiresAt);

            // return generated otp
            return new ResponseEntity<>(new ApiResponseWithObjectDTO<String>("Otp generated successfully",true,Otp),HttpStatus.CREATED);
        }
        catch (CustomExceptionHandler e){
            throw e;
        }
        catch (Exception e){
            throw new RuntimeException(String.format("Exception in creating OTP for email %s",email));
        }
    }


    // OTP verification



    // Forgot Password (Create totally new password)




    // verify email



    // change password ( Using old password )



}

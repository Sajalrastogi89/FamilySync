package com.example.FamilySync.Services.ServiceImplementors;

import com.example.FamilySync.DTO.requestDTO.UserDTO;
import com.example.FamilySync.Exceptions.CustomExceptionHandler;
import com.example.FamilySync.Exceptions.OTPGenerationException;
import com.example.FamilySync.Models.User;
import com.example.FamilySync.Repositories.UserDAO;
import com.example.FamilySync.Services.AuthService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

@Service
public class AuthServiceImplementation implements AuthService {

    private final UserDAO userDAO;
    private final ModelMapper modelMapper;

    public AuthServiceImplementation(UserDAO userDAO, ModelMapper modelMapper) {
        this.userDAO = userDAO;
        this.modelMapper = modelMapper;
    }


    @Override
    public boolean checkUser(String email) {
       User user=userDAO.findByEmail(email);
       if(user==null){
           return false;
       }
       return user.getVerified();
    }

    @Override
    public void registerUser(User user) {
        User checkUser=userDAO.findByEmail(user.getEmail());
        if(checkUser!=null){
            checkUser.setUsername(user.getUsername());
            checkUser.setImage(user.getImage());
            checkUser.setEmail(user.getEmail());
            checkUser.setPassword(user.getPassword());
            userDAO.save(checkUser);
        }
        else {
            userDAO.save(user);
        }
    }

    @Override
    public User DtoToUser(UserDTO userDTO) {
        return modelMapper.map(userDTO, User.class);
    }

    @Override
    public UserDTO userToDto(User user) {
        return modelMapper.map(user, UserDTO.class);
    }

    @Override
    public String generateRandomOTP() {
        return String.format("%06d", new Random().nextInt(999999));
    }

    @Override
    public void storeOtpAndExpiry(String email, String otp, LocalDateTime expiresAt) {
       User user=userDAO.findByEmail(email);
       if(user==null){
           throw new CustomExceptionHandler(String.format("%s does not exists",email), HttpStatus.BAD_REQUEST);
       }
       else{
           user.setEmailOTP(otp);
           user.setEmailOTPExpirationTime(expiresAt);
           userDAO.save(user);
       }
    }


}

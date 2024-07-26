package com.example.FamilySync.Services;

import com.example.FamilySync.DTO.requestDTO.UserDTO;
import com.example.FamilySync.Models.User;

import java.time.LocalDateTime;
import java.util.Optional;

public interface AuthService {
    boolean checkUser(String email);
    void registerUser(User user);
    User DtoToUser(UserDTO userDTO);
    UserDTO userToDto(User user);
    String generateRandomOTP();
    void storeOtpAndExpiry(String email, String otp, LocalDateTime expiresAt);
}

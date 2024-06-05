package com.example.FamilySync.Services;

import com.example.FamilySync.DTO.UserRegistrationDto;
import com.example.FamilySync.Entities.User;

public interface UserRegistrationService {
   User registerUser(UserRegistrationDto userRegistrationDto);
   void sendEmail(String to, String subject, String body);

}

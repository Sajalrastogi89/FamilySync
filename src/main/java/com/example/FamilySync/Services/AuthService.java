package com.example.FamilySync.Services;

import com.example.FamilySync.DTO.UserDTO;
import com.example.FamilySync.Models.User;

public interface AuthService {
    boolean checkUser(String email);
    void registerUser(User user);
    User DtoToUser(UserDTO userDTO);
    UserDTO userToDto(User user);


}

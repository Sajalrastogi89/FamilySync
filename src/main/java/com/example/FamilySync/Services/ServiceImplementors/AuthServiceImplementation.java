package com.example.FamilySync.Services.ServiceImplementors;

import com.example.FamilySync.DTO.UserDTO;
import com.example.FamilySync.Models.User;
import com.example.FamilySync.Repositories.UserDAO;
import com.example.FamilySync.Services.AuthService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

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
}

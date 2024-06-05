package com.example.FamilySync.Repositories;

import com.example.FamilySync.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<User,Long> {
    User findByUsername(String username);
    User findByEmail(String email);
}

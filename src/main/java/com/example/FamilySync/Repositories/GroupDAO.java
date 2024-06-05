package com.example.FamilySync.Repositories;

import com.example.FamilySync.Entities.Group;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupDAO extends JpaRepository<Group,Long> {
}

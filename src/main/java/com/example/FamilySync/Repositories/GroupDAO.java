package com.example.FamilySync.Repositories;

import com.example.FamilySync.Models.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupDAO extends JpaRepository<Group,Long> {
}

package com.example.FamilySync.Repositories;

import com.example.FamilySync.Models.Medical;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicalDAO extends JpaRepository<Medical,Long> {
}

package com.example.FamilySync.Repositories;

import com.example.FamilySync.Entities.Medical;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicalDAO extends JpaRepository<Medical,Long> {
}

package com.example.FamilySync.Repositories;

import com.example.FamilySync.Entities.Document;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentDAO extends JpaRepository<Document,Long> {
}

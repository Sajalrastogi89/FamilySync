package com.example.FamilySync.Repositories;

import com.example.FamilySync.Models.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentDAO extends JpaRepository<Document,Long> {
}

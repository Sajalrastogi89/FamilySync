package com.example.FamilySync.Repositories;

import com.example.FamilySync.Models.Folder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FolderDAO extends JpaRepository<Folder,Long> {
}

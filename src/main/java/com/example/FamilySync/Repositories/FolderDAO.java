package com.example.FamilySync.Repositories;

import com.example.FamilySync.Entities.Folder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FolderDAO extends JpaRepository<Folder,Long> {
}

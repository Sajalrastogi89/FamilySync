package com.example.FamilySync.Repositories;

import com.example.FamilySync.Models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskDAO extends JpaRepository<Task,Long> {
}

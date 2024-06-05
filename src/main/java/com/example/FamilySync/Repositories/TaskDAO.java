package com.example.FamilySync.Repositories;

import com.example.FamilySync.Entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskDAO extends JpaRepository<Task,Long> {
}

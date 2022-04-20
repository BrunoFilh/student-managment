package com.bruno.studentmanagment.repositories;

import com.bruno.studentmanagment.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepo extends JpaRepository<Task, Long> {
}

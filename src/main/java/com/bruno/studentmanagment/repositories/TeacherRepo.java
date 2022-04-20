package com.bruno.studentmanagment.repositories;

import com.bruno.studentmanagment.models.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepo extends JpaRepository<Teacher, Long> {
}

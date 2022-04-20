package com.bruno.studentmanagment.repositories;

import com.bruno.studentmanagment.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student, Long> {
}

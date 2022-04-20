package com.bruno.studentmanagment.services;

import com.bruno.studentmanagment.models.Student;
import com.bruno.studentmanagment.models.Task;

import java.util.Collection;

public interface StudentServices {

    Student createNewStudent(Student student);
    Collection<Student> fetchAllStudents();
    Student getStudentByID(Long id);
    void updateStudent(Student student);
    Boolean deleteStudentByID(Long id);
}

package com.bruno.studentmanagment.services;

import com.bruno.studentmanagment.models.Teacher;

import java.util.Collection;

public interface TeacherService {
    Teacher createNewTeacher(Teacher teacher);
    Collection<Teacher> getAllTeachers();
    Teacher getTeacherById(Long id);
    void updateTeacher(Teacher teacher);
    Boolean deleteTeacherById(Long id);
}

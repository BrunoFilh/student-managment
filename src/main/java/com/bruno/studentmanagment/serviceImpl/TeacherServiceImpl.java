package com.bruno.studentmanagment.serviceImpl;

import com.bruno.studentmanagment.models.Teacher;
import com.bruno.studentmanagment.repositories.TeacherRepo;
import com.bruno.studentmanagment.services.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService {
    private final TeacherRepo repository;

    @Override
    public Teacher createNewTeacher(Teacher teacher) {
        return repository.save(teacher);
    }

    @Override
    public Collection<Teacher> getAllTeachers() {
        return repository.findAll();
    }

    @Override
    public Teacher getTeacherById(Long id) {
        return repository.findById(id).orElseThrow();
    }

    @Override
    public void updateTeacher(Teacher teacher) {
        repository.findById(teacher.getId())
                .ifPresentOrElse(repository::save, () -> {
                    throw new IllegalStateException("Teacher with id " + teacher.getId() + " not found");
                });
    }

    @Override
    public Boolean deleteTeacherById(Long id) {
        if(repository.findById(id).isPresent()){
            repository.deleteById(id);
            return TRUE;
        }
        return FALSE;
    }
}

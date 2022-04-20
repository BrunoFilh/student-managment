package com.bruno.studentmanagment.serviceImpl;

import com.bruno.studentmanagment.models.Student;
import com.bruno.studentmanagment.repositories.StudentRepo;
import com.bruno.studentmanagment.services.StudentServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Collection;
import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentServices {

    private final StudentRepo studentRepo;

    @Override
    public Student createNewStudent(Student student) {
        return studentRepo.save(student);
    }

    @Override
    public Collection<Student> fetchAllStudents() {
        return studentRepo.findAll();
    }

    @Override
    public Student getStudentByID(Long id) {
        return studentRepo.findById(id).orElseThrow();
    }

    @Override
    public void updateStudent(Student student) {
        studentRepo.findById(student.getId()).ifPresentOrElse(
                studentRepo::save, () -> {
                    throw new IllegalStateException("Student with id " + student.getId() + " not found!");
                }
        );
    }

    @Override
    public Boolean deleteStudentByID(Long id) {
        if(studentRepo.findById(id).isPresent()){
            studentRepo.deleteById(id);
            return TRUE;
        }
        return FALSE;
    }

}

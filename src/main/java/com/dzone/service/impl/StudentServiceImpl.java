package com.dzone.service.impl;

import com.dzone.api.Student;
import com.dzone.repository.StudentRepository;
import com.dzone.service.StudentService;

import javax.inject.Inject;
import java.util.List;

public class StudentServiceImpl implements StudentService {
@Inject
    StudentRepository studentRepository;
    @Inject
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student save(Student student){
            return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudent() {
        return studentRepository.getAll();
    }

    @Override
    public Student getStudentById(String id) {
        return studentRepository.getById(id);
    }

    @Override
    public Student updateStudent(Student student) {
        return null;
    }

    @Override
    public void delete(String id) {

    }
}

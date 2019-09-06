package com.dzone.service.impl;

import com.dzone.api.Student;
import com.dzone.db.MongoDb;
import com.dzone.repository.StudentRepository;
import com.dzone.repository.impl.StudentRepositoryImpl;
import com.dzone.service.StudentService;

import javax.inject.Inject;
import java.util.List;

public class StudentServiceImpl implements StudentService {

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

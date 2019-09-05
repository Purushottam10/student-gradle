package service.impl;

import api.Student;
import repository.StudentRepository;
import service.StudentService;

import javax.inject.Inject;
import java.util.List;

public class StudentServiceImpl implements StudentService {

    @Inject
    StudentRepository studentRepository;
    @Override
    public Student save(Student student) {
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

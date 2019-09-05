package service;

import api.Student;

import java.util.List;

public interface StudentService {
    Student save(Student student);
    List<Student> getAllStudent();
    Student getStudentById(String Id);
    Student updateStudent(Student student);
    void delete(String id);
}

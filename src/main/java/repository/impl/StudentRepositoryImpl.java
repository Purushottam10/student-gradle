package repository.impl;

import api.Student;
import db.MongoDb;
import repository.StudentRepository;


public class StudentRepositoryImpl extends BaseRepositoryImpl<Student> implements StudentRepository {

    public StudentRepositoryImpl(MongoDb mongoManager, Class<Student> clazz) throws Exception {
        super(mongoManager, clazz);
    }
}

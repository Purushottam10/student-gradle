package com.dzone.repository.impl;

import com.dzone.api.Student;
import com.dzone.db.MongoDb;
import com.dzone.repository.StudentRepository;


public class StudentRepositoryImpl extends BaseRepositoryImpl<Student> implements StudentRepository {

    public StudentRepositoryImpl(MongoDb mongoManager, Class<Student> clazz) throws Exception {
        super(mongoManager, clazz);
    }
}

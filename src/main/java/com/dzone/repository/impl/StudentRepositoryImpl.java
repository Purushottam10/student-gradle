package com.dzone.repository.impl;

import com.dzone.api.Student;
import com.dzone.db.MongoDb;
import com.dzone.repository.StudentRepository;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;


public class StudentRepositoryImpl extends BaseRepositoryImpl<Student> implements StudentRepository {

    @Inject
    public StudentRepositoryImpl(MongoDb mongoManager) throws Exception {
      super(mongoManager, Student.class);
    }

}

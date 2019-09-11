package com.dzone.configuration;

import com.dzone.db.MongoDb;
import com.dzone.mapper.MongoManager;
import com.dzone.repository.StudentRepository;
import com.dzone.repository.impl.StudentRepositoryImpl;
import com.dzone.resource.StudentResource;
import com.dzone.service.StudentService;
import com.dzone.service.impl.StudentServiceImpl;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;


public class ApplicationConnector extends AbstractModule /*AbstractBinder*/ {
    static MongoManager mongoManager;
    @Override
    protected void configure() {
        bind(StudentService.class).to(StudentServiceImpl.class);
        bind(StudentRepository.class).to(StudentRepositoryImpl.class);
      //  bind(StudentServiceImpl.class).asEagerSingleton();
       // bind(AppConfiguration.class);
        // bind(MongoDb.class).to(MongoManager.class);
        //  bind(BaseRepository.class).to(BaseRepositoryImpl.class);
//        bind(StudentResource.class);
    }

    @Provides
    private synchronized MongoDb getMongoManagement(AppConfiguration configuration){
        if(mongoManager == null){
            mongoManager = new MongoManager(configuration);
        }
        return mongoManager;
}
}
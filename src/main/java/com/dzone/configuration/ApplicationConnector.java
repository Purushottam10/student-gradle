package com.dzone.configuration;

import com.dzone.repository.StudentRepository;
import com.dzone.repository.impl.StudentRepositoryImpl;
import com.dzone.service.StudentService;
import com.dzone.service.impl.StudentServiceImpl;
import com.google.inject.AbstractModule;
import ru.vyarus.dropwizard.guice.module.context.ConfigurationContext;


import javax.annotation.PostConstruct;


public class ApplicationConnector extends AbstractModule /*AbstractBinder*/ {

    private final ConfigurationContext context;

    public ApplicationConnector(ConfigurationContext context) {
        this.context = context;
    }

    @PostConstruct
    @Override
    protected void configure() {
        bind(StudentService.class).to(StudentServiceImpl.class);
        bind(StudentRepository.class).to(StudentRepositoryImpl.class);
    }


}
package com.dzone.module;

import com.dzone.configuration.AppConfiguration;
import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.Provides;
import com.google.inject.name.Named;

public class AppModule implements Module {
    @Override
    public void configure(Binder binder) {

    }

    /*@Provides
    @Named("message")
    public String provideMessage(AppConfiguration serverConfiguration) {
        return serverConfiguration.getTemplate();
    }*/
}

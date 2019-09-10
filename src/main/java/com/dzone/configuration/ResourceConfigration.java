package com.dzone.configuration;

import com.dzone.resource.StudentResource;
import io.dropwizard.jersey.DropwizardResourceConfig;
import org.glassfish.jersey.server.ResourceConfig;

import java.util.Map;

public class ResourceConfigration extends DropwizardResourceConfig{

   /* @Override
    public ResourceConfig register(Object component) {
        return super.register("/localhost:8099");
    }
    @Override
    public ResourceConfig property(String name, Object value) {
        return super.property("studentResource", StudentResource.class);
    }*/

}

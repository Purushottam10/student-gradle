package com.dzone.configuration;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;

import javax.validation.Valid;

public class AppConfiguration extends Configuration {


    private String template;
    // private StudentService studentService;

    private String defaultName = "Stranger";

    @Valid
    @JsonProperty("cors.urls")
    private String coreUrls = "http://localhost:8099,http://localhost:8091";

    public MongoConfiguration getMongoConfiguration() {
        return mongoConfiguration;
    }

    public void setMongoConfiguration(MongoConfiguration mongoConfiguration) {
        this.mongoConfiguration = mongoConfiguration;
    }

    public String getCoreUrls() {
        return coreUrls;
    }

    public void setCoreUrls(String coreUrls) {
        this.coreUrls = coreUrls;
    }

    @Valid
    @JsonProperty("mongoserver")
    public MongoConfiguration mongoConfiguration;

    @JsonProperty
    public String getTemplate() {
        return template;
    }

    @JsonProperty
    public void setTemplate(String template) {
        this.template = template;
    }

    @JsonProperty
    public String getDefaultName() {
        return defaultName;
    }

    @JsonProperty
    public void setDefaultName(String name) {
        this.defaultName = name;
    }


}

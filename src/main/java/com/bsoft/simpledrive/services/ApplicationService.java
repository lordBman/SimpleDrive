package com.bsoft.simpledrive.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
@PropertySource("classpath:custom.properties")
public class ApplicationService {
    private final Environment environment;

    public ApplicationService(@Autowired Environment environment){
        this.environment = environment;
    }

    @Value("${simpledrive.version}")
    private String version;

    @Value("${spring.application.name}")
    private String name;

    @Value("${simpledrive.author}")
    private String author;

    public String getVersion() {
        return version;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getOS(){
        return environment.getProperty("os.name");
    }

    public String getJavaVersion(){
        return environment.getProperty("java.version");
    }
}

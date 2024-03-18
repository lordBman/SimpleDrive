package com.bsoft.simpledrive.services;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {
    
    @Bean
    FilesService files(){
        return new FilesService();
    }

    @Bean
    UserService users(){
        return new UserService();
    }
}

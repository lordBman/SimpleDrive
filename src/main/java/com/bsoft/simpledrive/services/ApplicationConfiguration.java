package com.bsoft.simpledrive.services;

import com.bsoft.simpledrive.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bsoft.simpledrive.repository.FilesRepository;

@Configuration
public class ApplicationConfiguration {
    final FilesRepository filesRepository;
    final UserRepository userRepository;

    ApplicationConfiguration(@Autowired FilesRepository filesRepository, @Autowired UserRepository userRepository){
        this.filesRepository = filesRepository;
        this.userRepository = userRepository;
    }

    @Bean
    FilesService files(){
        return new FilesService(filesRepository);
    }

    @Bean
    UserService users(){
        return new UserService(userRepository);
    }
}

package com.bsoft.simpledrive.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import com.bsoft.simpledrive.models.User;
import com.bsoft.simpledrive.repository.UserRepository;

public class UserService {
    private final UserRepository userRepository;
    UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public ArrayList<User> all(){
        return (ArrayList<User>) this.userRepository.findAll();
    }
}

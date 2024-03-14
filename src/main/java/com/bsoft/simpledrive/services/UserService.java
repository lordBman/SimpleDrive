package com.bsoft.simpledrive.services;

import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.bsoft.simpledrive.models.User;

@Service
public class UserService {
    HashMap<String, User> users;

    UserService(){
        this.users = new HashMap<>();
    }
}

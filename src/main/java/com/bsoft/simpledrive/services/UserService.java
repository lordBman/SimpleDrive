package com.bsoft.simpledrive.services;

import java.util.HashMap;

import com.bsoft.simpledrive.models.users.User;

public class UserService {
    HashMap<String, User> users;

    UserService(){
        this.users = new HashMap<>();
    }
}

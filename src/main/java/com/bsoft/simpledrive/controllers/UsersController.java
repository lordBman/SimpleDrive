package com.bsoft.simpledrive.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.bsoft.simpledrive.models.User;
import com.bsoft.simpledrive.services.UserService;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

record SignUpForm(String name, String surname, String email, String password) {}
record LoginForm(String email, String password) {}

@RestController
public class UsersController {

    @Autowired
    UserService userService;

    @PostMapping("/users")
    public ResponseEntity<User> create(@RequestBody SignUpForm form) {
        String id = UUID.randomUUID().toString();

        User user = new User( id, form.name(), form.surname(), form.email(), form.password());

        HttpHeaders headers = new HttpHeaders();
        headers.add("Set-Cookie", "token=wellItWorks");

        return ResponseEntity.status(HttpStatusCode.valueOf(201)).headers(headers).body(user);
    }

    @PostMapping("/users/login")
    public ResponseEntity<User> login(@RequestBody LoginForm form) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Set-Cookie", "token=wellItWorks");

        return ResponseEntity.ok().headers(headers).body(null);
    }

    @GetMapping("/users")
    public String get(@CookieValue(value = "token", defaultValue = "") String token) {
        return token;
    }
    
}

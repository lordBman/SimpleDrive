package com.bsoft.simpledrive.controllers;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RestController;

import com.bsoft.simpledrive.models.User;
import com.bsoft.simpledrive.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;

record SignUpForm(String name, String surname, String email, String password) {}
record LoginForm(String email, String password) {}

@RestController
public class UsersController {

    @Autowired
    UserService userService;

    @PostMapping("/users")
    public ResponseEntity<User> create(@RequestBody @Valid SignUpForm form) {
        User user = new User( form.name(), form.surname(), form.email(), form.password());

        HttpHeaders headers = new HttpHeaders();
        headers.add("Set-Cookie", "token=wellItWorks");

        return ResponseEntity.status(HttpStatusCode.valueOf(201)).headers(headers).body(user);
    }

    @PostMapping("/users/login")
    public ResponseEntity<User> login(@RequestBody @Valid LoginForm form) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Set-Cookie", "token=wellItWorks");

        return ResponseEntity.ok().headers(headers).body(null);
    }

    @GetMapping("/users")
    public String get(@CookieValue(value = "token", defaultValue = "") String token) {
        return token;
    }

    @GetMapping("/")
    public ArrayList<User> all(@CookieValue(value = "token", defaultValue = "") String token) {
        return userService.all();
    }
    
}

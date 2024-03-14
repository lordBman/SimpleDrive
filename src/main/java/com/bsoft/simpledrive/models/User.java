package com.bsoft.simpledrive.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

public record User(String id, String name, String surname, String email, @JsonIgnore String password){}

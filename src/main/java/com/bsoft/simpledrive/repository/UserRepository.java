package com.bsoft.simpledrive.repository;

import org.springframework.data.repository.CrudRepository;

import com.bsoft.simpledrive.models.User;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {
}

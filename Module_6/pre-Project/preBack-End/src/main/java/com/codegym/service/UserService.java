package com.codegym.service;

import com.codegym.model.User;

import java.util.List;

public interface UserService {
    List<User>getAllUsers();

    void save(User user);

    User findById(long id);

    void delete(long id);
}

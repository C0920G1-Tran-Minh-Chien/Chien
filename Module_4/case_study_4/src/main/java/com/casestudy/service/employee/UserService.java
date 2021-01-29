package com.casestudy.service.employee;

import com.casestudy.model.Employee;
import com.casestudy.model.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    void save(User user);
}

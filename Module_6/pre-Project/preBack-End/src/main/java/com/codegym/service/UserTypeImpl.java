package com.codegym.service;

import com.codegym.model.UserType;
import com.codegym.repository.UserTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserTypeImpl implements UserTypeService {
    @Autowired
    UserTypeRepository userTypeRepository;
    @Override
    public List<UserType> getAllUserType() {
        return userTypeRepository.findAll();
    }
}

package com.example.manytomany.service;

import com.example.manytomany.model.Student;
import com.example.manytomany.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void save(Student student){
        this.customerRepository.save(student);
    }

    @Override
    public Student findById(int id) {
        return customerRepository.findById(id);
    }

}

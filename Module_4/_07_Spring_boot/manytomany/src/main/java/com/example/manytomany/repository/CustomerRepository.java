package com.example.manytomany.repository;

import com.example.manytomany.model.Student;
import org.aspectj.apache.bcel.util.Repository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface CustomerRepository extends Repository {

    void save(Student student);

    Student findById(int id);
}

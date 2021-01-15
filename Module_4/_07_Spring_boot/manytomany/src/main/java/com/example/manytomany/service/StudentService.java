package com.example.manytomany.service;

import com.example.manytomany.model.Student;
import org.springframework.stereotype.Service;

@Service
public interface StudentService {
    public void save(Student student);
    public Student findById(int id);
}

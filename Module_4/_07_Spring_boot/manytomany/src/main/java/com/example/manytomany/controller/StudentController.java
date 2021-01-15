package com.example.manytomany.controller;

import com.example.manytomany.model.Course;
import com.example.manytomany.model.Student;
import com.example.manytomany.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/registStudentToCourse")
    public void registStudentToCourse(){
        Course courseA = new Course("A");
        Course courseB = new Course("B");

        Student student1 = new Student("C");

        Set<Course> courses = new HashSet<>();

        courses.add(courseA);
        courses.add(courseB);
        student1.setLikedCourses(courses);

        this.studentService.save(student1);
    }

    @GetMapping("/getStudent/{id}")
    public Student getStudent(@PathVariable int id){
        return this.studentService.findById(id);
    }
}

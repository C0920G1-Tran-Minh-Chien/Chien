package com.example.manytomany.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "student")
public class Student {
    public Student(String c) {
    }

    @Id
    @Column(name = "id")
    private int id;

    @ManyToMany
    @JoinTable(name = "student_course" , joinColumns = @JoinColumn(name = "student_id"), inverseJoinColumns = @JoinColumn(name = "course_id"))
    private Set<Course> likedCourses;

    public void setLikedCourses(Set<Course> courses) {
    }
}

package com.example.manytomany.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "course")
public class Course {
    public Course() {
    }

    public Course(String a) {
    }

    public Course(Set<Student> likes) {
        this.likes = likes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<Student> getLikes() {
        return likes;
    }

    public void setLikes(Set<Student> likes) {
        this.likes = likes;
    }

    @Id
    @Column(name = "id")
    private int id;

    @ManyToMany(mappedBy = "likedCourses")
    private Set<Student> likes;
}

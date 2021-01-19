package com.codeym.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "education_degree")
public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    @OneToMany(mappedBy = "education")
    private List<Employee> employee;

    public Education() {
    }

    public Education(String name, List<Employee> employee) {
        this.name = name;
        this.employee = employee;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmployee() {
        return employee;
    }

    public void setEmployee(List<Employee> employee) {
        this.employee = employee;
    }
}

package com.casestudy.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "customer_type")
public class Customer_type {

    @Id
    @GeneratedValue
    private int id;
    private String name;

    @OneToMany(mappedBy = "customer_type")
    Set<Customer> customerSet;

    public Customer_type() {
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

    public Set<Customer> getCustomers() {
        return customerSet;
    }

    public void setCustomers(Set<Customer> customers) {
        this.customerSet = customers;
    }
}

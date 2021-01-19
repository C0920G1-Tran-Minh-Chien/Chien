package com.casestudy.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String dateOfBirth;
    private String gender;
    private String cmnd;
    private String phoneNumb;
    private String email;
    private String address;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private CustomerType customerType;

    public Customer() {
    }
    @OneToMany(mappedBy = "customer")
    private List<Contract> contracts;

    public Customer(String name, String dateOfBirth, String gender, String cmnd, String phoneNumb, String email, String address, CustomerType customerType) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.cmnd = cmnd;
        this.phoneNumb = phoneNumb;
        this.email = email;
        this.address = address;
        this.customerType = customerType;
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

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public String getPhoneNumb() {
        return phoneNumb;
    }

    public void setPhoneNumb(String phoneNumb) {
        this.phoneNumb = phoneNumb;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }
}

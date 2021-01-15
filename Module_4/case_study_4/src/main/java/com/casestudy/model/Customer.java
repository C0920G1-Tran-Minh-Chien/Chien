package com.casestudy.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue
    private String id;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "customer_type_id", referencedColumnName = "id")
    private Customer_type customer_type;

    private String name;
    private Date birthDay;
    private int gender;
    private String id_card;
    private String phone;
    private String email;
    private String address;

    public Customer() {
    }

    public Customer(String id,Customer_type customer_type, String name, Date birthDay, int gender, String id_card,
                    String phone, String email, String address) {
        this.id = id;
        this.customer_type = customer_type;
        this.name = name;
        this.birthDay = birthDay;
        this.gender = gender;
        this.id_card = id_card;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Customer_type getCustomer_type() {
        return customer_type;
    }

    public void setCustomer_type(Customer_type customer_type) {
        this.customer_type = customer_type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getId_card() {
        return id_card;
    }

    public void setId_card(String id_card) {
        this.id_card = id_card;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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
}

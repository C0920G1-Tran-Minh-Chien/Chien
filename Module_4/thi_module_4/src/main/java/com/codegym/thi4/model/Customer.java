package com.casestudy.model;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "customer")
public class Customer implements Validator {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotBlank(message = "Name must not be Blank")
    private String name;

    @DateTimeFormat(pattern = "yyyy-mm-dd")
    @PastOrPresent
    private Date dateOfBirth;

    private String gender;

    @NotBlank(message = "Idcard must not be Blank")
    @Size(min = 9, max = 9)
    private String cmnd;

    @NotEmpty
    @Size(min = 10, max = 10)
    @Pattern(regexp = "^0\\d{9}$")
    private String phoneNumb;

    @NotBlank(message = "Email must not be Blank")
    @Email
    private String email;

    @NotBlank(message = "Address must not be Blank")
    private String address;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private CustomerType customerType;

    public Customer() {
    }

    @OneToMany(mappedBy = "customer")
    private List<Contract> contracts;

    public Customer(String name, Date dateOfBirth, String gender, String cmnd, String phoneNumb, String email, String address, CustomerType customerType) {
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

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
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

    @Override
    public boolean supports(Class<?> clazz) {
        return Customer.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Customer customer = (Customer) target;
        LocalDate today = LocalDate.now();
        Date birth = customer.getDateOfBirth();
        if (birth == null) {
            errors.rejectValue("dateOfBirth", "DateNotNull");
        } else {
            LocalDate birthLocal =  birth.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            if (Period.between(birthLocal, today).getYears()<18) {
                errors.rejectValue("dateOfBirth", "DateCustomer");
            }
        }
        //        ValidationUtils.rejectIfEmpty(errors, "name", "mess.empty");

    }
}

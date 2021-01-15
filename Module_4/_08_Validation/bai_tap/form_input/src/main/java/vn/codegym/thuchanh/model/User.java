package vn.codegym.thuchanh.model;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Component
public class User implements Validator {

    @NotEmpty
    @Size(min = 2, max = 15)
    private String name;
    @Min(18)
    private int age;

    private String phone;

    @NotEmpty
    @Email(message = "Nhap lai email")
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        String phoneNumber = user.getPhone();
        ValidationUtils.rejectIfEmpty(errors, "phone", "mess.empty");
        if (phoneNumber.length() > 11 || phoneNumber.length() < 10){
            errors.rejectValue("phone", "mess.length");
        }
        if (!phoneNumber.startsWith("0")){
            errors.rejectValue("phone", "mess.startsWith");
        }
        if (!phoneNumber.matches("(^$|[0-9]*$)")){
            errors.rejectValue("phone", "mess.matches");
        }
    }
}

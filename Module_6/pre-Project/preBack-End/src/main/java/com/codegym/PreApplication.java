package com.codegym;

import com.codegym.model.User;
import com.codegym.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PreApplication{

    public static void main(String[] args) {

        SpringApplication.run(PreApplication.class, args);
    }

    @Autowired
    UserRepository userRepository;
//
//    @Override
//    public void run(String... args) throws Exception {
//        this.userRepository.save(new User("Chien", "Minh", "Qb"));
//        this.userRepository.save(new User("Hung", "Quoc", "Qb"));
//        this.userRepository.save(new User("Thinh", "Dinh", "Qb"));
//    }
}

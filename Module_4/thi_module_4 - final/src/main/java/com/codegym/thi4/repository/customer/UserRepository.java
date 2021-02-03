package com.codegym.thi4.repository.customer;

import com.codegym.thi4.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}

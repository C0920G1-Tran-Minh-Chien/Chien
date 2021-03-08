package com.codegym.repository;

import com.codegym.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u")
    List<User> findAll();

    @Query("select u from User u where u.id = ?1")
    User findById(long id);

    @Query("delete  from User u where u.id = ?1")
    Void deleteById(long id);

//    @Query("insert into User")
//    Void save(User user);
}

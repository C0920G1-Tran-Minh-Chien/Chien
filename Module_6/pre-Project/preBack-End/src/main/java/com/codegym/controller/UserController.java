package com.codegym.controller;

import com.codegym.model.User;
import com.codegym.model.UserType;
import com.codegym.repository.UserRepository;
import com.codegym.service.UserTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserTypeService userTypeService;
    @GetMapping("/users")
    public Page<User> getUsers(@RequestParam(defaultValue = "0") int page) {
        return this.userRepository.findAll(PageRequest.of(page,3));
    }

//    Lay List UserType
    @GetMapping("/usertype")
    public List<UserType> getUserType(){
        return userTypeService.getAllUserType();
    }

//    Lay doi tượng user = id.
    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable(value = "id") Long id){
        User user = userRepository.findById(id).orElse(null);
        return ResponseEntity.ok().body(user);
    }

//    Tạo mới User
    @PostMapping(value = "/users/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public User goCreateUser(@RequestBody User user){
        userTypeService.getAllUserType();
        return userRepository.save(user);
    }

//    Chỉnh sửa User
    @PutMapping("/users/{id}")
    public  ResponseEntity<User> updateUser(@PathVariable(value = "id") Long id, @RequestBody User userDetails){
        User user = userRepository.findById(id).orElse(null);
        user.setFirstName(userDetails.getFirstName());
        user.setLastName(userDetails.getLastName());
        user.setEmail(userDetails.getEmail());
        user.setImgUrl(userDetails.getImgUrl());
        user.setUserType(userDetails.getUserType());
        User updateUser = userRepository.save(user);
        return ResponseEntity.ok(updateUser);
    }

//    Xóa User
    @DeleteMapping("/users/{id}")
    public Map<String, Boolean> deleteUser(@PathVariable(value = "id") Long id){
        User user = userRepository.findById(id).orElse(null);
        userRepository.deleteById(id);
        Map<String, Boolean> reponse = new HashMap<>();
        reponse.put("deleted", Boolean.TRUE);
        return reponse;
    }
}

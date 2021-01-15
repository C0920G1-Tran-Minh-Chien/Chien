package com.codegym.giohang.service;

import com.codegym.giohang.model.Customer;
import org.springframework.stereotype.Service;

@Service
public interface CustomerService {
    Iterable<Customer> findAll();

    Customer findById(int id);

    void save(Customer customer);

    void remove(int id);
}

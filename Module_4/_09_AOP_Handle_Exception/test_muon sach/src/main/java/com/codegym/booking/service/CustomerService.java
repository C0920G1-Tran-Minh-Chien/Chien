package com.codegym.booking.service;

import com.codegym.booking.model.Book;
import com.codegym.booking.model.Customer;
import org.springframework.stereotype.Service;

@Service
public interface CustomerService {
    Iterable<Customer> findAll();

    Customer findById(int id);

    void save(Customer customer);

    void remove(int id);
}

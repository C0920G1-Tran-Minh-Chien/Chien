package com.codegym.muon_sach.service;

import com.codegym.muon_sach.model.Customer;
import org.springframework.stereotype.Service;

@Service
public interface CustomerService {
    Iterable<Customer> findAll();

    Customer findById(int id);

    void save(Customer customer);

    void remove(int id);
}

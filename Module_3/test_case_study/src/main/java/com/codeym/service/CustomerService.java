package com.codeym.service;

import com.codeym.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CustomerService {
    List<Customer> getAllCustomer();

    void save(Customer customer);

    Customer findById(int id);

    void delete(int id);

    Page<Customer> findAll(Pageable pageable);

    Page<Customer> search(String searchName, Pageable pageable);
}


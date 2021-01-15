package com.codegym.muon_sach.repository;

import com.codegym.muon_sach.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}

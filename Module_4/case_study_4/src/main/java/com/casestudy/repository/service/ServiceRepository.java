package com.casestudy.repository.service;

import com.casestudy.model.Employee;
import com.casestudy.model.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<Service, Integer> {
    Page<Service> findByNameContaining(String searchString, Pageable pageable);
}

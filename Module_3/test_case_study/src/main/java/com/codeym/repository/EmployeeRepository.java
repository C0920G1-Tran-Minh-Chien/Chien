package com.codeym.repository;

import com.codeym.model.Customer;
import com.codeym.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    Page<Employee> findByNameContaining(String searchString, Pageable pageable);
}

package com.codeym.service;

import com.codeym.model.Customer;
import com.codeym.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployee();

    void save(Employee employee);

    Employee findById(int id);

    void delete(int id);

    Page<Employee> findAll(Pageable pageable);

    Page<Employee> search(String searchName, Pageable pageable);

}

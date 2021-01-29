package com.casestudy.service.employee;

import com.casestudy.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {
    List<Employee> getAllEmployee();

    void save(Employee employee);

    Employee findById(int id);

    void delete(int id);

    Page<Employee> findAll(Pageable pageable);

    Page<Employee> search(String searchName, Pageable pageable);
}

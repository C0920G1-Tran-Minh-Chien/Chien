package com.casestudy.repository.employee;
import com.casestudy.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    Page<Employee> findByNameContaining(String searchString, Pageable pageable);
}

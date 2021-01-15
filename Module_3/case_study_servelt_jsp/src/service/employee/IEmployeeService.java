package service.employee;

import model.Employee;

import java.util.List;

public interface IEmployeeService {
    List<Employee> selectAllEmployee();

    Employee selectEmployeeById();

     void insertEmployee(Employee employee);

    void deleteEmployee(String id);

    void updateEmployee(Employee employee);

    List<Employee> selectEmployeeByName(String name);
}

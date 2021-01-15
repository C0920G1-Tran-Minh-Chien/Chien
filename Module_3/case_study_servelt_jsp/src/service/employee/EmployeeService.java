package service.employee;

import model.Employee;
import repository.employee.EmployeeRepository;

import java.util.List;

public class EmployeeService implements IEmployeeService {
    EmployeeRepository employeeRepository = new EmployeeRepository();
    @Override
    public List<Employee> selectAllEmployee() {
        return employeeRepository.selectAllEmployee();
    }

    @Override
    public Employee selectEmployeeById() {
        return null;
    }

    @Override
    public  void insertEmployee(Employee employee) {
        employeeRepository.insertEmployee(employee);
    }

    @Override
    public void deleteEmployee(String id) {
        employeeRepository.deleteEmployee(id);
    }

    @Override
    public void updateEmployee(Employee employee) {
        employeeRepository.updateEmployee(employee);
    }

    @Override
    public List<Employee> selectEmployeeByName(String name) {
        return employeeRepository.selectEmployeeByName(name);
    }
}

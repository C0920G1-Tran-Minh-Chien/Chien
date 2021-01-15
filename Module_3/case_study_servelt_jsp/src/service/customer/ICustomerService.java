package service.customer;

import model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> selectAllCustomer();

    Customer selectCustomerById();

    void insertCustomer(Customer customer);

    void deleteCustomer(String id);

    void updateCustomer(Customer customer);

    List<Customer> selectCustomerByName(String name);

    int countCustomer();
}

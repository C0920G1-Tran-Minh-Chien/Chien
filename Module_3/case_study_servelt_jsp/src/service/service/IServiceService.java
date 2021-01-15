package service.service;

import model.Customer;
import model.Service;

import java.util.List;

public interface IServiceService {
    List<Service> selectAllService();

    Customer selectServiceById();

    void insertService(model.Service service);

    void deleteService(String id);

    void updateService(model.Service service);

    List<Service> selectServiceByName(String name);
}

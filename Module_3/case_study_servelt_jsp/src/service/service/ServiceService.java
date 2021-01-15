package service.service;

import model.Customer;
import model.Service;
import repository.service.ServiceRepository;

import java.util.List;

public class ServiceService implements IServiceService {
    ServiceRepository serviceRepository = new ServiceRepository();
    @Override
    public List<Service> selectAllService() {
        return serviceRepository.selectAllService();
    }

    @Override
    public Customer selectServiceById() {
        return null;
    }

    @Override
    public void insertService(Service service) {
        serviceRepository.insertService(service);
    }

    @Override
    public void deleteService(String id) {

    }

    @Override
    public void updateService(Service service) {

    }

    @Override
    public List<Service> selectServiceByName(String name) {
        return null;
    }
}

package com.casestudy.service.Impl.service;

import com.casestudy.model.Service;
import com.casestudy.repository.service.ServiceRepository;
import com.casestudy.service.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@org.springframework.stereotype.Service
public class ServiceServiceImpl implements ServiceService {
    @Autowired
    ServiceRepository serviceRepository;

    @Override
    public List<Service> getAllService() {
        return serviceRepository.findAll();
    }

    @Override
    public void save(Service service) {
        serviceRepository.save(service);
    }

    @Override
    public Service findById(int id) {
        return serviceRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(int id) {
        serviceRepository.deleteById(id);
    }

    @Override
    public Page<Service> findAll(Pageable pageable) {
        return serviceRepository.findAll(pageable);
    }

    @Override
    public Page<Service> search(String searchName, Pageable pageable) {
        return serviceRepository.findByNameContaining(searchName, pageable);
    }
}

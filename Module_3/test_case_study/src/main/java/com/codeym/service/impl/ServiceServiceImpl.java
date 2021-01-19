package com.codeym.service.impl;

import com.codeym.repository.ServiceRepository;
import com.codeym.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceServiceImpl implements ServiceService {
    @Autowired
    private ServiceRepository serviceRepository;

    @Override
    public List<com.codeym.model.Service> getAllService() {
        return serviceRepository.findAll();
    }

    @Override
    public void save(com.codeym.model.Service service) {
        serviceRepository.save(service);
    }

    @Override
    public com.codeym.model.Service findById(int id) {
        return serviceRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(int id) {
        serviceRepository.deleteById(id);
    }

    @Override
    public Page<com.codeym.model.Service> findAll(Pageable pageable) {
        return serviceRepository.findAll(pageable);
    }

    @Override
    public Page<com.codeym.model.Service> search(String searchName, Pageable pageable) {
        return serviceRepository.findByNameContaining(searchName, pageable);
    }
}

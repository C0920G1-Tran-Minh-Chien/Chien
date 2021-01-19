package com.codeym.service.impl;

import com.codeym.model.ServiceType;
import com.codeym.repository.ServiceTypeRepository;
import com.codeym.service.ServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceTypeServiceImpl implements ServiceTypeService {
    @Autowired
    private ServiceTypeRepository serviceTypeRepository;
    @Override
    public List<ServiceType> getAllServiceType() {
        return serviceTypeRepository.findAll();
    }
}

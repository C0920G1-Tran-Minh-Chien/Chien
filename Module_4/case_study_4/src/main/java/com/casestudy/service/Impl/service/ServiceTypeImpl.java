package com.casestudy.service.Impl.service;

import com.casestudy.model.ServiceType;
import com.casestudy.repository.service.ServiecTypeRepositpry;
import com.casestudy.service.service.ServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceTypeImpl implements ServiceTypeService {
    @Autowired
    ServiecTypeRepositpry serviecTypeRepositpry;
    @Override
    public List<ServiceType> findAll() {
        return serviecTypeRepositpry.findAll();
    }
}

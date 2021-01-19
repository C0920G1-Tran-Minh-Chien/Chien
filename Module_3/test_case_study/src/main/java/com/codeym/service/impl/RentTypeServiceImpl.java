package com.codeym.service.impl;

import com.codeym.model.RentType;
import com.codeym.repository.RentTypeRepository;
import com.codeym.service.RentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentTypeServiceImpl implements RentTypeService {
    @Autowired
    private RentTypeRepository rentTypeRepository;
    @Override
    public List<RentType> getAllRentType() {
        return rentTypeRepository.findAll();
    }
}

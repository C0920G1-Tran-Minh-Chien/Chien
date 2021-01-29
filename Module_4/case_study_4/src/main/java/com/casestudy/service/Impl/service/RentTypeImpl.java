package com.casestudy.service.Impl.service;

import com.casestudy.model.RentType;
import com.casestudy.repository.service.RentTypeRepository;
import com.casestudy.service.service.RentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentTypeImpl implements RentTypeService {
    @Autowired
    RentTypeRepository rentTypeRepository;
    @Override
    public List<RentType> findAll() {
        return rentTypeRepository.findAll();
    }
}

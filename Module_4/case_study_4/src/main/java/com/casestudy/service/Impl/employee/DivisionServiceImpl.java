package com.casestudy.service.Impl.employee;

import com.casestudy.model.Division;
import com.casestudy.repository.employee.DivisionRepository;
import com.casestudy.service.employee.DivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DivisionServiceImpl implements DivisionService {
    @Autowired
    DivisionRepository divisionRepository;

    @Override
    public List<Division> findAll() {
        return divisionRepository.findAll();
    }
}

package com.codeym.service.impl;

import com.codeym.model.Division;
import com.codeym.repository.DivisionRepository;
import com.codeym.service.DivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DivisionServiceImpl implements DivisionService {
    @Autowired
    private DivisionRepository divisionRepository;
    @Override
    public List<Division> getAllDivision() {
        return divisionRepository.findAll();
    }
}

package com.codeym.service.impl;

import com.codeym.model.Education;
import com.codeym.repository.EducationRepository;
import com.codeym.service.EducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationServiceImpl implements EducationService {
    @Autowired
    private EducationRepository educationRepository;
    @Override
    public List<Education> getAllEducation() {
        return educationRepository.findAll();
    }
}

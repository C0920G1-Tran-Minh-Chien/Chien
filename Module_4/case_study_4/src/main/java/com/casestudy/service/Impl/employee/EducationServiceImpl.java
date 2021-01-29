package com.casestudy.service.Impl.employee;

import com.casestudy.model.Education;
import com.casestudy.repository.employee.EducationRepository;
import com.casestudy.service.employee.EducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationServiceImpl implements EducationService {
    @Autowired
    EducationRepository educationRepository;
    @Override
    public List<Education> findAll() {
        return educationRepository.findAll();
    }
}

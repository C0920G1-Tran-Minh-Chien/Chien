package com.codegym.thi4.service.customer;


import com.codegym.thi4.model.QuestionType;
import com.codegym.thi4.repository.customer.QuestionTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionTypeServiceImpl implements QuestionTypeService {
    @Autowired
    private QuestionTypeRepository questionTypeRepository;
    @Override
    public List<QuestionType> findAll() {
        return questionTypeRepository.findAll();
    }
}

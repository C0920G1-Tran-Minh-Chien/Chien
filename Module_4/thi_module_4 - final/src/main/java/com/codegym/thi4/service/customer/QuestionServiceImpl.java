package com.codegym.thi4.service.customer;



import com.codegym.thi4.model.Question;
import com.codegym.thi4.repository.customer.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private QuestionRepository questionRepository;
    @Override
    public List<Question> getAllCustomer() {
        return questionRepository.findAll();
    }

    @Override
    public void save(Question question) {
        questionRepository.save(question);
    }

    @Override
    public Question findById(int id) {
        return questionRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(int id) {
        questionRepository.deleteById(id);
    }

    @Override
    public Page<Question> findAll(Pageable pageable) {
        return questionRepository.findAll(pageable);
    }

    @Override
    public Page<Question> search(String searchName, Pageable pageable) {
        return questionRepository.findByTitleContaining(searchName, pageable);
    }

}

package com.codegym.thi4.service.customer;

import com.codegym.thi4.model.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface QuestionService {
    List<Question> getAllCustomer();

    void save(Question question);

    Question findById(int id);

    void delete(int id);


    Page<Question> findAll(Pageable pageable);

    Page<Question> search(String searchName, Pageable pageable);
}


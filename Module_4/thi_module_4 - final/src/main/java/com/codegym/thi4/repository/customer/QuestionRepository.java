package com.codegym.thi4.repository.customer;

import com.codegym.thi4.model.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
        Page<Question> findByTitleContaining(String searchString, Pageable pageable);
}

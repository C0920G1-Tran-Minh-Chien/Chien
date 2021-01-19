package com.codegym.quan_ly.repository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface Repository <T> {
    List<T> findAll();

    T findById(Long id);

    void save(T model);

    void remove(Long id);
}
package com.codegym.giohang.service;

import com.codegym.giohang.model.Book;
import org.springframework.stereotype.Service;

@Service
public interface BookService {
    Iterable<Book> findAll();

    Book findById(int id);

    void save(Book book);

    void remove(int id);
}

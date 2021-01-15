package com.codegym.booking.service;

import com.codegym.booking.model.Book;
import org.springframework.stereotype.Service;

@Service
public interface BookService {
    Iterable<Book> findAll();

    Book findById(int id);

    void save(Book book);

    void remove(int id);
}

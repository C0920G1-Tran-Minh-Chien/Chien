package com.codegym.booking.service;

import com.codegym.booking.model.Book;
import com.codegym.booking.model.OrderBook;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface OrderBookService {
    Page<OrderBook> findAll (Pageable pageable);

    OrderBook findById(int id);

    void save(OrderBook orderBook);

    void remove(int id);

    Iterable<OrderBook> findAllByBook(Book book);

}

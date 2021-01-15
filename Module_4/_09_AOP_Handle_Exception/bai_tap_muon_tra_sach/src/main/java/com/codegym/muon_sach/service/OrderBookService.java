package com.codegym.muon_sach.service;

import com.codegym.muon_sach.model.Book;
import com.codegym.muon_sach.model.OrderBook;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface OrderBookService {
    Page<OrderBook> findAll(Pageable pageable);

    OrderBook findByCode(int id);

    void save(OrderBook orderBook);

    void remove(int id);

    Iterable<OrderBook> findAllByBook(Book book);

}

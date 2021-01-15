package com.codegym.muon_sach.repository;

import com.codegym.muon_sach.model.Book;
import com.codegym.muon_sach.model.OrderBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderBookRepository extends JpaRepository<OrderBook, Integer> {
    Iterable<OrderBook> findAllByBook(Book book);
    OrderBook findByCode(int code);
}

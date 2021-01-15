package com.codegym.giohang.repository;

import com.codegym.giohang.model.Book;
import com.codegym.giohang.model.OrderBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderBookRepository extends JpaRepository<OrderBook, Integer> {
    Iterable<OrderBook> findAllByBook(Book book);
    OrderBook findByCode(int code);
}

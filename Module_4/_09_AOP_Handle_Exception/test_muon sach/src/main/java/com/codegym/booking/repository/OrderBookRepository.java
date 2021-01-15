package com.codegym.booking.repository;

import com.codegym.booking.model.Book;
import com.codegym.booking.model.OrderBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderBookRepository extends JpaRepository<OrderBook, Integer> {
    Iterable<OrderBook> findAllByBook(Book book);

}

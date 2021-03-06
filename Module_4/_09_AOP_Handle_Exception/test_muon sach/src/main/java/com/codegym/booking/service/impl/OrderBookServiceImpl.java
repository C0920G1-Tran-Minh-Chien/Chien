package com.codegym.booking.service.impl;

import com.codegym.booking.model.Book;
import com.codegym.booking.model.OrderBook;
import com.codegym.booking.repository.OrderBookRepository;
import com.codegym.booking.service.OrderBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class OrderBookServiceImpl implements OrderBookService {

    @Autowired
    private OrderBookRepository orderBookRepository;

    @Override
    public Page<OrderBook> findAll(Pageable pageable) {
        return orderBookRepository.findAll(pageable);
    }

    @Override
    public OrderBook findById(int id) {
        return orderBookRepository.findById(id).orElse(null);
    }

    @Override
    public void save(OrderBook orderBook) {
        orderBookRepository.save(orderBook);
    }

    @Override
    public void remove(int id) {
        orderBookRepository.deleteById(id);
    }

    @Override
    public Iterable<OrderBook> findAllByBook(Book book) {
        return orderBookRepository.findAllByBook(book);
    }
}

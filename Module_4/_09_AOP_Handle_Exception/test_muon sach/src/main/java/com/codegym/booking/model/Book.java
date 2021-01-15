package com.codegym.booking.model;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Set;

@Entity
@Table(name = "sach")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private int amount;

    @OneToMany(mappedBy = "book")
    private Set<OrderBook> orderBookSet;

    public Book() {
    }

    public Book(String name, int amount){
        this.name = name;
        this.amount = amount;
    }
    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Set<OrderBook> getOrderBookSet() {
        return orderBookSet;
    }

    public void setOrderBookSet(Set<OrderBook> orderBookSet) {
        this.orderBookSet = orderBookSet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    }

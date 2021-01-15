package com.codegym.booking.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue
    private int id;

    private String name;

    @OneToMany(mappedBy = "customer")
    private Set<OrderBook> orderBookSet;

    public Customer() {
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

    public Set<OrderBook> getOrderBookSet() {
        return orderBookSet;
    }

    public void setOrderBookSet(Set<OrderBook> orderBookSet) {
        this.orderBookSet = orderBookSet;
    }
}

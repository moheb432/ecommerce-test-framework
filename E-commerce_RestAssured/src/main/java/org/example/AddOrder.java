package org.example;

import java.util.ArrayList;
import java.util.List;

public class AddOrder {
    private List<Order> orders = new ArrayList<Order>();
    public AddOrder() {}

    public List<Order> getorders() {
        return orders;
    }


    public void setorders(List<Order> orders) {
        this.orders = orders;
    }
}
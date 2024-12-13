package org.example;

import java.util.ArrayList;

public class Customer {
    private String custName;
    private ArrayList<Order> orderHistory;
    private int custID;

    private static int nextCustID = 1000;

    public Customer(String custName) {
        this.custName = custName;
        this.custID = nextCustID++;
        this.orderHistory = new ArrayList<>();
    }

    public String getName() {
        return custName;
    }

    public int getID() {
        return custID;
    }

    public ArrayList<Order> getOrderHistory() {
        return orderHistory;
    }

    public void addToHistory(Order order) {
        orderHistory.add(order);
    }

}
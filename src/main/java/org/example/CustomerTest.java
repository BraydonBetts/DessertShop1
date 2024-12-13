package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerTest {

    @Test
    public void testGetName() {
        Customer customer = new Customer("John Doe");
        // Verify that the name is returned correctly.
        assertEquals("John Doe", customer.getName());
    }

    @Test
    public void testGetID() {
        Customer customer1 = new Customer("John Doe");
        Customer customer2 = new Customer("Jane Smith");
        // Verify unique customer IDs.
        assertEquals(1000, customer1.getID(), "The first customer should have an ID of 1000.");
        assertEquals(1001, customer2.getID(), "The second customer should have an ID of 1001.");
    }

    @Test
    public void testAddToOrderHistory() {
        Customer customer = new Customer("Jane Doe");
        Order order = new Order();
        // Add an order to the customer's history.
        customer.addToHistory(order);
        // Verify the order history size and content.
        assertEquals(1, customer.getOrderHistory().size());
        assertEquals(order, customer.getOrderHistory().get(0));
    }



    @Test
    public void testGetOrderHistory() {
        Customer customer = new Customer("Alice Smith");
        Order order1 = new Order();
        Order order2 = new Order();
        customer.addToHistory(order1);
        customer.addToHistory(order2);

        // Verify the size and order of the history.
        assertEquals(2, customer.getOrderHistory().size(), "Order history should contain 2 orders.");
        assertEquals(order1, customer.getOrderHistory().get(0), "First order in history should match order1.");
        assertEquals(order2, customer.getOrderHistory().get(1), "Second order in history should match order2.");
    }

    @Test
    public void testCustomerIDUniqueness() {
        Customer customer1 = new Customer("Charlie Brown");
        Customer customer2 = new Customer("Lucy Van Pelt");
        // Verify that customer IDs are unique.
        assertNotEquals(customer1.getID(), customer2.getID(), "Customer IDs should be unique.");
    }
}

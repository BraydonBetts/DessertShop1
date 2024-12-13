package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DessertItemTest {

    @Test
    void testGetTaxPercent() {
        Candy candy = new Candy("Candy Corn", 1.5, 0.25);
        assertEquals(7.25, candy.getTaxPercent(), 0.001);
    }

    @Test
    void testSetTaxPercent() {
        Candy candy = new Candy("Candy Corn", 1.5, 0.25);
        candy.setTaxPercent(8.0);
        assertEquals(8.0, candy.getTaxPercent(), 0.001);
    }

    @Test
    void testCalculateCost() {
        Candy candy = new Candy("Candy Corn", 1.5, 0.25);
        assertEquals(0.375, candy.calculateCost(), 0.001);
    }

    @Test
    void testCalculateTax() {
        Candy candy = new Candy("Candy Corn", 1.5, 0.25);
        assertEquals(0.0272, candy.calculateTax(), 0.001);
    }

    @Test
    void testCalculateCostWithCustomTax() {
        Candy candy = new Candy("Candy Corn", 1.5, 0.25);
        double customTax = 10.0;
        assertEquals(0.375 * (customTax / 100), candy.calculateCost(customTax), 0.001);
    }

    @Test
    void testCalculateTaxWithCustomTax() {
        Candy candy = new Candy("Candy Corn", 1.5, 0.25);
        double customTax = 10.0;
        assertEquals(0.375 * (customTax / 100), candy.calculateTax(customTax), 0.001);
    }


    @Test
    void testCompareTo() {
        Candy candy1 = new Candy("Candy Corn", 1.5, 0.25);  // Cost: 0.375
        Candy candy2 = new Candy("Candy Corn", 1.0, 0.50);  // Cost: 0.50

        assertTrue(candy1.compareTo(candy2) < 0);
        assertTrue(candy2.compareTo(candy1) > 0);
        assertTrue(candy1.compareTo(candy1) == 0);
    }
}

package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CandyTest {

    @Test
    public void testCalculateCost() {
        Candy candy = new Candy("Candy Corn", 1.5, 0.25);
        assertEquals(0.375, candy.calculateCost(), 0.001, "Cost calculation is incorrect.");
    }

    @Test
    public void testCalculateTax() {
        Candy candy = new Candy("Candy Corn", 1.5, 0.25);
        assertEquals(0.0272, candy.calculateTax(), 0.001, "Tax calculation is incorrect.");
    }

    @Test
    public void testToString() {
        Candy candy = new Candy("Candy Corn", 1.5, 0.25);
        String expected = "Candy Corn (Bag)   1.50 lbs. @ $0.25/lb.: $0.38";
        assertEquals(expected, candy.toString(), "String representation is incorrect.");
    }

    @Test
    public void testSetAndGetPackaging() {
        Candy candy = new Candy("Candy Corn", 1.5, 0.25);
        candy.setPackaging("Box");
        assertEquals("Box", candy.getPackaging(), "Packaging was not set or retrieved correctly.");
    }

    @Test
    public void testIsSameAsTrue() {
        Candy candy1 = new Candy("Candy Corn", 1.5, 0.25);
        Candy candy2 = new Candy("Candy Corn", 2.0, 0.25);
        assertTrue(candy1.isSameAs(candy2), "Candy objects should be considered the same.");
    }

    @Test
    public void testIsSameAsFalse() {
        Candy candy1 = new Candy("Candy Corn", 1.5, 0.25);
        Candy candy2 = new Candy("Candy Corn", 1.5, 0.30);
        assertFalse(candy1.isSameAs(candy2), "Candy objects should not be considered the same.");
    }
}

package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class IceCreamTest {

    @Test
    public void testCalculateCost() {
        IceCream iceCream = new IceCream("Pistachio", 2, 0.79);
        assertEquals(1.58, iceCream.calculateCost(), 0.001);  // 2 scoops * $0.79 per scoop
    }

    @Test
    public void testCalculateTax() {
        IceCream iceCream = new IceCream("Pistachio", 2, 0.79);
        assertEquals(0.1141, iceCream.calculateTax(), 0.001);  // Tax: 1.58 * 7.25%
    }

    @Test
    public void testToString() {
        IceCream iceCream = new IceCream("Pistachio", 2, 0.79);
        String expected = String.format("%-40s%-50s%-15s%s",
                "Pistachio (Bowl)", "2 scoops @ $0.79/scoop:", "$1.58", "[Tax: $0.11]");
        assertEquals(expected, iceCream.toString());
    }

    @Test
    public void testSetAndGetScoopCount() {
        IceCream iceCream = new IceCream("Pistachio", 2, 0.79);
        iceCream.setScoopCount(3);
        assertEquals(3, iceCream.getScoopCount());
    }

    @Test
    public void testSetAndGetPricePerScoop() {
        IceCream iceCream = new IceCream("Pistachio", 2, 0.79);
        iceCream.setPricePerScoop(1.00);
        assertEquals(1.00, iceCream.getPricePerScoop(), 0.001);
    }

    @Test
    public void testSetAndGetPackaging() {
        IceCream iceCream = new IceCream("Pistachio", 2, 0.79);
        iceCream.setPackaging("Cone");
        assertEquals("Cone", iceCream.getPackaging());
    }

    @Test
    public void testCalculateCostWithCustomTax() {
        IceCream iceCream = new IceCream("Pistachio", 2, 0.79);
        double customTax = 10.0;
        assertEquals(1.58 * (customTax / 100), iceCream.calculateCost(customTax), 0.001);
    }

    @Test
    public void testCalculateTaxWithCustomTax() {
        IceCream iceCream = new IceCream("Pistachio", 2, 0.79);
        double customTax = 10.0;
        assertEquals(1.58 * (customTax / 100), iceCream.calculateTax(customTax), 0.001);
    }

    @Test
    public void testIceCreamInitialization() {
        IceCream iceCream = new IceCream("Pistachio", 2, 0.79);
        assertEquals("Pistachio", iceCream.getName());
        assertEquals(2, iceCream.getScoopCount());
        assertEquals(0.79, iceCream.getPricePerScoop(), 0.001);
        assertEquals("Bowl", iceCream.getPackaging());  // Default packaging is "Bowl"
    }
}
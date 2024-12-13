package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SundaeTest {

    @Test
    public void testCalculateCost() {
        Sundae sundae = new Sundae("Vanilla", 3.0);
        assertEquals(3.0, sundae.calculateCost(), 0.001);
    }

    @Test
    public void testCalculateTax() {
        Sundae sundae = new Sundae("Vanilla", 3.0);
        assertEquals(0.2175, sundae.calculateTax(), 0.001);
    }

    @Test
    public void testGetPackaging() {
        Sundae sundae = new Sundae("Chocolate Syrup", 1.25);
        assertEquals("Bowl with Topping", sundae.getPackaging(), "Default packaging should be 'Bowl with Topping'.");
    }

    @Test
    public void testSetPackaging() {
        Sundae sundae = new Sundae("Chocolate Syrup", 1.25);
        sundae.setPackaging("Custom Bowl");
        assertEquals("Custom Bowl", sundae.getPackaging(), "Packaging should be updated to 'Custom Bowl'.");
    }
    @Test
    public void testToString() {
        Sundae sundae = new Sundae("Chocolate Syrup", 1.25);
        String expectedOutput = String.format("%-40s%-20s%s",
                "Chocolate Syrup (Bowl with Topping)",
                "$1.25",
                String.format("[Tax: $%.2f]", sundae.calculateTax()));
        assertEquals(expectedOutput, sundae.toString(), "toString() output should match the expected format.");
    }

}

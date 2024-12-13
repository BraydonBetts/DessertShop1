package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CookieTest {

    @Test
    public void testCalculateCost() {
        Cookie cookie = new Cookie("Chocolate Chip", 6, 3.99);
        assertEquals(1.995, cookie.calculateCost(), 0.001);
    }

    @Test
    public void testCalculateTax() {
        Cookie cookie = new Cookie("Chocolate Chip", 6, 3.99);
        assertEquals(0.1459, cookie.calculateTax(), 0.001);
    }

    @Test
    public void testToString() {
        Cookie cookie = new Cookie("Chocolate Chip", 6, 3.99);
        String expected = String.format("%-15s%-10s%-10s%s",
                "Chocolate Chip (Bag)", "6 @ $3.99/dozen:", "$1.99", "[Tax: $0.15]");
        assertEquals(expected, cookie.toString());
    }

    @Test
    public void testSetAndGetPackaging() {
        Cookie cookie = new Cookie("Chocolate Chip", 6, 3.99);
        cookie.setPackaging("Box");
        assertEquals("Box", cookie.getPackaging());
    }

    @Test
    public void testIsSameAs() {
        Cookie cookie1 = new Cookie("Chocolate Chip", 6, 3.99);
        Cookie cookie2 = new Cookie("Chocolate Chip", 12, 3.99);
        Cookie cookie3 = new Cookie("Chocolate Chip", 6, 3.99);
        assertTrue(cookie1.isSameAs(cookie3));
        assertFalse(cookie1.isSameAs(cookie2));
    }
}

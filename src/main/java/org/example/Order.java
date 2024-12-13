package org.example;

import java.util.ArrayList;
import java.util.Collections;

public class Order implements Payable {
    private ArrayList<DessertItem> items;
    private PayType payMethod;

    public Order() {
        items = new ArrayList<>();
        this.payMethod = PayType.CASH;
    }

    public void addItem(DessertItem item) {
        items.add(item);
        boolean added = false;

        if (item instanceof Candy) {
            for (DessertItem otherItem : items) {
                if (otherItem instanceof Candy) {
                    Candy currentCandy = (Candy) otherItem;
                    Candy newCandy = (Candy) item;

                    // Compare using isSameAs
                    if (currentCandy.isSameAs(newCandy)) {
                        currentCandy.setCandyWeight(currentCandy.getCandyWeight() + newCandy.getCandyWeight());
                        added = true;
                        break;  // Item is merged, exit loop
                    }
                }
            }
        }

        else if (item instanceof Cookie) {
            for (DessertItem otherItem : items) {
                if (otherItem instanceof Cookie) {
                    Cookie currentCookie = (Cookie) otherItem;
                    Cookie newCookie = (Cookie) item;

                    if (currentCookie.isSameAs(newCookie)) {
                        currentCookie.setCookieQty(currentCookie.getCookieQty() + newCookie.getCookieQty());
                        added = true;
                        break;  // Item is merged, exit loop
                    }
                }
            }
        }

        if (!added) {
            items.add(item);
        }
    }

    public void printOrder() {
        for (DessertItem item : items) {
            System.out.printf("%s: $%.2f [Tax: $%.2f]%n", item.getName(), item.calculateCost(), item.calculateTax());
        }
    }

    public int getTotalItems() {
        return items.size();
    }

    public double orderCost() {
        double totalCost = 0.0;
        for (DessertItem item : items) {
            totalCost += item.calculateCost();
        }
        return totalCost;
    }

    public double orderTax() {
        double totalTax = 0.0;
        for (DessertItem item : items) {
            totalTax += item.calculateTax();
        }
        return totalTax;
    }


    @Override
    public String toString() {
        Collections.sort(items);

        //Print receipt
        StringBuilder finalOutput = new StringBuilder();
        finalOutput.append("\n----------------------------------Receipt----------------------------------\n");
        for (DessertItem item : items) {
            finalOutput.append(item.toString()).append("\n");
        }
        finalOutput.append("---------------------------------------------------------------------------\n");

        //Calculate order totals
        double subtotal = orderCost();
        double tax = orderTax();
        double total = subtotal + tax;
        int totalItems = getTotalItems();

        finalOutput.append(String.format("Total number of items in order: %d%n", totalItems));
        finalOutput.append(String.format("Order Subtotals: $%.2f [Tax: $%.2f]%n%n", subtotal, tax));
        finalOutput.append(String.format("Order Total: $%.2f%n", total));
        finalOutput.append("---------------------------------------------------------------------------\n");

        // Add payment type
        finalOutput.append(String.format("Paid for with %s.%n", getPayType()));
        finalOutput.append("---------------------------------------------------------------------------\n");

        return finalOutput.toString();
    }

    private double calculateCost() {
        double totalCost = 0.0;
        for (DessertItem item : items) {
            totalCost += item.calculateCost();
        }
        return totalCost;
    }

    private double calculateTax() {
        double totalTax = 0.0;
        for (DessertItem item : items) {
            totalTax += item.calculateTax();
        }
        return totalTax;
    }

    @Override
    public PayType getPayType() {
        return this.payMethod;
    }

    @Override
    public void setPayType(PayType payMethod) {
        this.payMethod = payMethod;
    }

}

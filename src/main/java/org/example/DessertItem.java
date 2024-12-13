package org.example;

public abstract class DessertItem implements Comparable<DessertItem>{
    protected String name;
    protected double taxPercent = 7.25;

    public DessertItem(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTaxPercent() {
        return taxPercent;
    }

    public void setTaxPercent(double taxPercent) {
        this.taxPercent = taxPercent;
    }

    public abstract double calculateCost();

    public double calculateCost(double taxPercent) {
        return calculateCost() * (taxPercent / 100);
    }

    public abstract double calculateTax();

    public double calculateTax (double taxPercent) {
        return calculateCost() * (taxPercent / 100);
    }


    @Override
    public int compareTo(DessertItem other) {

        double cost = this.calculateCost();
        double otherCost = other.calculateCost();
        if (cost < otherCost) {
            return -1;
        } else if (cost > otherCost) {
            return 1;
        } else {
            return 0; //Both items with same cost
        }
    }
}
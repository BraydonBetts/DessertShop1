package org.example;

public class Sundae extends DessertItem implements Packable {
    private String packaging;
    private String toppingName;
    private double toppingPrice;

    //Constructor
    public Sundae(String toppingName, double toppingPrice) {
        super(toppingName);
        this.toppingName = toppingName;
        this.toppingPrice = toppingPrice;
        this.packaging = "Bowl with Topping";
    }

    //Getters and Setters
    public String getToppingName() {
        return toppingName;
    }

    public void setToppingName(String toppingName) {
        this.toppingName = toppingName;
    }

    public double getToppingPrice() {
        return toppingPrice;
    }

    public void setToppingPrice(double toppingPrice) {
        this.toppingPrice = toppingPrice;
    }
    @Override
    public double calculateCost() {
        return toppingPrice;
    }

    @Override
    public double calculateTax() {
        return calculateCost() * (taxPercent / 100);
    }

    @Override
    public String getPackaging() {
        return packaging;
    }

    @Override
    public void setPackaging(String packaging) {
        this.packaging = packaging;
    }


    @Override
    public String toString() {
        String line1 = String.format("%s (%s)", this.getName(), this.getPackaging());
        String line2Pt1 = String.format("$%.2f", calculateCost());
        String line2Pt2 = String.format("[Tax: $%.2f]", calculateTax());

        return String.format("%-40s%-20s%s", line1, line2Pt1, line2Pt2);
    }
}
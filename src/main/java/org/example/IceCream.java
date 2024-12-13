package org.example;

public class IceCream extends DessertItem implements Packable {
    private String packaging;
    private int scoopCount;
    private double pricePerScoop;

    //Constructor
    public IceCream(String name, int scoopCount, double pricePerScoop) {
        super(name);
        this.scoopCount = scoopCount;
        this.pricePerScoop = pricePerScoop;
        this.packaging = "Bowl";  // Default packaging type
    }

    // Getters and Setters
    public int getScoopCount() {
        return scoopCount;
    }

    public void setScoopCount(int scoopCount) {
        this.scoopCount = scoopCount;
    }

    // Getter and Setter for pricePerScoop
    public double getPricePerScoop() {
        return pricePerScoop;
    }

    public void setPricePerScoop(double pricePerScoop) {
        this.pricePerScoop = pricePerScoop;
    }

    //Calculate the cost
    @Override
    public double calculateCost() {
        return scoopCount * pricePerScoop;
    }

    //Calculate the tax
    @Override
    public double calculateTax() {
        return calculateCost() * (taxPercent / 100);
    }

    @Override
    public String toString() {
        String line1 = String.format("%s (%s)", this.getName(), this.getPackaging());
        String line2Pt1 = String.format("%d scoops @ $%.2f/scoop:", scoopCount, pricePerScoop);
        String line2Pt2 = String.format("$%.2f", calculateCost());
        String line2Pt3 = String.format("[Tax: $%.2f]", calculateTax());
        return String.format("%-40s%-50s%-15s%s", line1, line2Pt1, line2Pt2, line2Pt3);
    }

    //Getter for packaging
    @Override
    public String getPackaging() {
        return packaging;
    }

    //Setter for packaging
    @Override
    public void setPackaging(String packaging) {
        this.packaging = packaging;
    }
}

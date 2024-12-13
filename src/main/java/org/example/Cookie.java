package org.example;

public class Cookie extends DessertItem implements Packable {
    private String packaging;
    private int cookieQty;
    private double pricePerDozen;

    //Constructor
    public Cookie(String name, int cookieQty, double pricePerDozen) {
        super(name);
        this.cookieQty = cookieQty;
        this.pricePerDozen = pricePerDozen;
        this.packaging = "Box";
    }

    public int getCookieQty() {
        return cookieQty;
    }

    public void setCookieQty(int cookieQty) {
        this.cookieQty = cookieQty;
    }

    public double getPricePerDozen() {
        return pricePerDozen;
    }

    public void setPricePerDozen(double pricePerDozen) {
        this.pricePerDozen = pricePerDozen;
    }

    @Override
    public double calculateCost() {
        return (cookieQty / 12.0) * pricePerDozen;
    }

    //Calculate the tax based on the cost
    @Override
    public double calculateTax() {
        return calculateCost() * (taxPercent / 100);  // Calculate tax based on cost
    }

    @Override
    public String toString() {
        // Format for each line to ensure proper alignment and information display
        String line1 = String.format("%s (%s)", this.getName(), this.getPackaging());
        String line2Pt1 = String.format("%d cookies @ $%.2f/dozen:", cookieQty, pricePerDozen);
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
    public boolean isSameAs(Cookie other) {
        if (this.getName().equals(other.getName()) && this.pricePerDozen == other.pricePerDozen){
            return true;
        }else {
            return false;
        }
    }
}


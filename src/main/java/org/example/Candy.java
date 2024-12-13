package org.example;

public class Candy extends DessertItem implements Packable {
    private String packaging;
    private double candyWeight;
    private double pricePerPound;
    private double taxPercent = 7.25;

    public Candy(String name, double candyWeight, double pricePerPound) {
        super(name);
        this.candyWeight = candyWeight;
        this.pricePerPound = pricePerPound;
        this.packaging = "Bag";
    }

    //Getters and Setters
    public double getCandyWeight() {
        return candyWeight;
    }

    public void setCandyWeight(double candyWeight) {
        this.candyWeight = candyWeight;
    }

    public double getPricePerPound() {
        return pricePerPound;
    }

    public void setPricePerPound(double pricePerPound) {
        this.pricePerPound = pricePerPound;
    }

    public double getTaxPercent() {
        return taxPercent;
    }

    public void setTaxPercent(double taxPercent) {
        this.taxPercent = taxPercent;
    }

    @Override
    public double calculateCost() {
        return candyWeight * pricePerPound;
    }

    @Override
    public double calculateTax() {
        return calculateCost() * (taxPercent / 100);
    }
    @Override
    public String toString() {
        String line1 = String.format("%s (%s)",this.getName(), this.getPackaging());
        String line2Pt1 = String.format("%.2f lbs. @ $%.2f/lb.:", candyWeight, pricePerPound);
        String line2Pt2 = String.format("$%.2f", calculateCost());
        String line2Pt3 = String.format("[Tax: $%.2f]", calculateTax());

        return String.format("%-15s%-10s%-10s%s", line1, line2Pt1, line2Pt2, line2Pt3);
    }

    @Override
    public String getPackaging() {
        return packaging;
    }

    @Override
    public void setPackaging(String packaging) {
        this.packaging = packaging;

    }
    //Checks item for same name
    public boolean isSameAs(Candy other) {
        if (this.getName().equals(other.getName()) && this.pricePerPound == other.pricePerPound){
            return true;
        }else {
            return false;
        }
    }
}


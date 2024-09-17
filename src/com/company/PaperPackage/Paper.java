package com.company.PaperPackage;

import java.io.Serializable;

public class Paper implements Serializable {
    private static final long serialVersionUID = 1L;
    private PaperType type;
    private double basePrice;
    private double priceIncreasePercentage;

    public Paper(PaperType type, double priceIncreasePercentage, double basePrice) {
        this.type = type;
        this.priceIncreasePercentage = priceIncreasePercentage;
        this.basePrice = basePrice;
    }

    public PaperType getType() {
        return type;
    }

    public double getPriceIncreasePercentage() {
        return priceIncreasePercentage;
    }

    public double calculatePrice(PageSize size) {
        if (size == PageSize.A5) {
            return basePrice;
        }
        int sizeMultiplier = switch (size) {
            case A4 -> 1;
            case A3 -> 2;
            case A2 -> 3;
            case A1 -> 4;
            default -> 0;
        };
        return basePrice + (basePrice * (priceIncreasePercentage*sizeMultiplier)/100);
    }

    @Override
    public String toString() {
        return "Paper [type=" + type + ", priceIncreasePercentage=" + priceIncreasePercentage + "]";
    }
}
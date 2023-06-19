package com.platzi.javatesting.discounts;

import java.util.ArrayList;
import java.util.List;

public class PriceCalculator {

    // lista precios
    private List<Double> prices = new ArrayList<>();
    private double discount = 0;

    public double getTotal() {

        //calcular la lista de los precios
        double result = 0;

        for (Double price : prices) {
            // suma
            result += price;
        }
        // resultado y aplicar descuento
        return result * ((100-discount)/100);
    }

    public void addPrice(double price) {
        prices.add(price);
    }

    public void setDiscount(double discount) {

        // campo discount
        this.discount = discount;
    }
}

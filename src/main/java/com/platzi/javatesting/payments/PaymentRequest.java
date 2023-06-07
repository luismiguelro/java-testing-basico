package com.platzi.javatesting.payments;

public class PaymentRequest {

    // Monto a pagar
    private double amount;

    //Constructor
    public PaymentRequest(double amount) {
        this.amount = amount;
    }

    // getter
    public double getAmount() {

        return amount;
    }
}

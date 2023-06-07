package com.platzi.javatesting.payments;

public class PaymentResponse {


    enum PaymentStatus {
        OK, ERROR
    }

    //Codigo de respuesta
    private PaymentStatus status;

    //Constructor
    public PaymentResponse(PaymentStatus status) {
        this.status = status;
    }

    // Getter
    public PaymentStatus getStatus() {
        return status;
    }
}

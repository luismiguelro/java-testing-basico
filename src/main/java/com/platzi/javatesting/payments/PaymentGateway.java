package com.platzi.javatesting.payments;

// Pasarela de pago
public interface PaymentGateway {

    // Petición de pago
    PaymentResponse requestPayment(PaymentRequest request);
}

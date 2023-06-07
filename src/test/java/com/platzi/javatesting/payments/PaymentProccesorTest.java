package com.platzi.javatesting.payments;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class PaymentProccesorTest {
    // pago correcto
    @Test
    public void payment_is_correct() {

        // Simular la pasarela de pago con Mockito
        PaymentGateway paymentGateway = Mockito.mock(PaymentGateway.class);

        // simular resultado: Mockito.any()-> Realizar cualquier tipo de request
        Mockito.when(paymentGateway.requestPayment(Mockito.any()))
                .thenReturn(new PaymentResponse(PaymentResponse.PaymentStatus.OK));

        // Procesador de pagos
        PaymentProccesor paymentProccesor = new PaymentProccesor(paymentGateway);

        // Probar que el pago sea correcto
        assertTrue(paymentProccesor.makePayment(1000));
    }

    // pago erroneo
    public void payment_is_wrong() {

        // Simular la pasarela de pago con Mockito
        PaymentGateway paymentGateway = Mockito.mock(PaymentGateway.class);

        // simular resultado: Mockito.any()-> Realizar cualquier tipo de request
        Mockito.when(paymentGateway.requestPayment(Mockito.any()))
                .thenReturn(new PaymentResponse(PaymentResponse.PaymentStatus.ERROR));

        // Procesador de pagos
        PaymentProccesor paymentProccesor = new PaymentProccesor(paymentGateway);

        // Probar que el pago no sea correcto
        assertFalse(paymentProccesor.makePayment(1000));
    }
}
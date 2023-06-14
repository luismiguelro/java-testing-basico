package com.platzi.javatesting.payments;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class PaymentProccesorTest {

    private PaymentGateway paymentGateway;
    private PaymentProccesor paymentProccesor;

    //Metodo comun: partes comunes de los tests
    @Before // se ejecuta antes de los test
    public void setup(){
        // Simular la pasarela de pago con Mockito
        paymentGateway = Mockito.mock(PaymentGateway.class);
        // Procesador de pagos
        paymentProccesor = new PaymentProccesor(paymentGateway);
    }
    // pago correcto
    @Test
    public void payment_is_correct() {
        // simular resultado: Mockito.any()-> Realizar cualquier tipo de request
        Mockito.when(paymentGateway.requestPayment(Mockito.any()))
                .thenReturn(new PaymentResponse(PaymentResponse.PaymentStatus.OK));

        // Probar que el pago sea correcto
        assertTrue(paymentProccesor.makePayment(1000));
    }

    // pago erroneo
    @Test
    public void payment_is_wrong() {

        // simular resultado: Mockito.any()-> Realizar cualquier tipo de request
        Mockito.when(paymentGateway.requestPayment(Mockito.any()))
                .thenReturn(new PaymentResponse(PaymentResponse.PaymentStatus.ERROR));


        // Probar que el pago no sea correcto
        assertFalse(paymentProccesor.makePayment(1000));
    }
}
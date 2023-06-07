package com.platzi.javatesting.payments;

// Procesador de pago
public class PaymentProccesor {

    // Pasarela de pago
    private PaymentGateway paymentGateway;

    // Pasarela, la cual se pasa a través del constructor
    public PaymentProccesor(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    //Verificar pago
    public boolean makePayment(double amount){
        //Llamar a la pasarela de pago
        PaymentResponse response = paymentGateway.requestPayment(new PaymentRequest(amount));

        // validar pago
        if (response.getStatus()== PaymentResponse.PaymentStatus.OK){
            return true;
        } else{
            return false;
        }

    }
}

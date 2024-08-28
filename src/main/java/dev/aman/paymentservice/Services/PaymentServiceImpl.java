package dev.aman.paymentservice.Services;

import com.razorpay.RazorpayException;
import com.stripe.exception.StripeException;
import dev.aman.paymentservice.Services.PaymentGateway.PaymentGateway;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

    private PaymentGateway paymentGateway;

    public PaymentServiceImpl(@Qualifier("stripepaymentgateway") PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    @Override
    public String initiatePayment(Long orderId, String name, int amount) throws StripeException, RazorpayException {
        // call the payment gateway to generate the payment link
        return paymentGateway.generatePaymentLink(orderId, name, amount);
    }
}

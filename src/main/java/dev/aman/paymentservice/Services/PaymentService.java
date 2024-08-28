package dev.aman.paymentservice.Services;

import com.razorpay.RazorpayException;
import com.stripe.exception.StripeException;
import org.springframework.stereotype.Service;

public interface PaymentService {

    String initiatePayment(Long orderId, String name, int amount) throws StripeException, RazorpayException;
}

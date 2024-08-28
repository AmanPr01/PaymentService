package dev.aman.paymentservice.Services.PaymentGateway;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentLink;
import com.stripe.model.Price;
import com.stripe.param.PaymentLinkCreateParams;
import com.stripe.param.PriceCreateParams;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service("stripepaymentgateway")
public class StripePaymentGateway implements PaymentGateway {

    @Value("${stripe.key.id}")
    private String stripeAPIkey;

//    @Override
//    public String generatePaymentLink(Long orderId, String name, int amount) throws StripeException {
//
//        Stripe.apiKey = stripeAPIkey;
//
//        PriceCreateParams priceCreateParams =
//                PriceCreateParams.builder()
//                        .setCurrency("inr")
//                        .setUnitAmount(1000L)
////                        .setRecurring(       // Basically subscription
////                                PriceCreateParams.Recurring.builder()
////                                        .setInterval(PriceCreateParams.Recurring.Interval.MONTH)
////                                        .build()
////                        )
//                        .setProductData(
//                                PriceCreateParams.ProductData.builder().setName("Gold Plan").build()
//                        )
//                        .build();
//
//        Price price = Price.create(priceCreateParams);
//
//        PaymentLinkCreateParams params =
//                PaymentLinkCreateParams.builder()
//                        .addLineItem(
//                                PaymentLinkCreateParams.LineItem.builder()
//                                        .setPrice(price.getId())
//                                        .setQuantity(1L)
//                                        .build()
//                        )
//                        .build();
//
//        PaymentLink paymentLink = PaymentLink.create(params);
//
//        return paymentLink.toString();
//    }

    @Override
    public String generatePaymentLink(Long orderId, String name, int amount) throws StripeException {
        Stripe.apiKey = stripeAPIkey;

        // Create price parameters
        PriceCreateParams priceCreateParams =
                PriceCreateParams.builder()
                        .setCurrency("inr")
                        .setUnitAmount(5000L) // Make sure to use the passed amount
                        .setProductData(
                                PriceCreateParams.ProductData.builder().setName(name).build()
                        )
                        .build();

        Price price = Price.create(priceCreateParams);

        // Create payment link parameters
        PaymentLinkCreateParams params =
                PaymentLinkCreateParams.builder()
                        .addLineItem(
                                PaymentLinkCreateParams.LineItem.builder()
                                        .setPrice(price.getId())
                                        .setQuantity(1L)
                                        .build()
                        )
                        .build();

        // Create payment link
        PaymentLink paymentLink = PaymentLink.create(params);

        // Return the payment link URL as a JSON string
        return paymentLink.toString(); // Directly return the URL of the payment link
    }


    @Override
    public boolean validatePayment(Long orderId) {
        return false;
    }
}

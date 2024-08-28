package dev.aman.paymentservice.Controllers;

import dev.aman.paymentservice.DTOs.InitiatePaymentRequestDTO;
import dev.aman.paymentservice.Services.PaymentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    private PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/")
    public String initiatePayment(@RequestBody InitiatePaymentRequestDTO requestDTO) {
        System.out.println("Initiate Payment API called with request: " + requestDTO);
        String payment = null;
        try {
            payment = paymentService.initiatePayment(
                    requestDTO.getOrderId(),
                    requestDTO.getName(),
                    requestDTO.getAmount()
            );
            System.out.println("Payment link generated: " + payment);
        } catch (Exception e) {
            System.out.println("Exception occurred: " + e.getMessage());
        }

        return payment;
    }
}

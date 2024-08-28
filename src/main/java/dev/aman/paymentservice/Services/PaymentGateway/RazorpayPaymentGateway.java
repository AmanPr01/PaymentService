//package dev.aman.paymentservice.Services.PaymentGateway;
//
//import com.razorpay.PaymentLink;
//import org.springframework.stereotype.Service;
//import org.json.JSONObject;
//import com.razorpay.Payment;
//import com.razorpay.RazorpayClient;
//import com.razorpay.RazorpayException;
//
//@Service("razorpaypaymentgateway")
//public class RazorpayPaymentGateway implements PaymentGateway {
//
//    private RazorpayClient razorpay;
//
//    public RazorpayPaymentGateway(RazorpayClient razorpay) {
//        this.razorpay = razorpay;
//    }
//
//    //10.56 -> 10.56 * 100 =>  1056
//    //9855 -> 98.55
//    //200 -> 2.00
//    //200 -> 20000
//    //2 * 100 -> 200 => 2.00
//    @Override
//    public String generatePaymentLink(Long orderId, String name, int amount) throws RazorpayException {
//        //Call the Razorpay API's to generate the payment Link.
//
//        //RazorpayClient razorpay = new RazorpayClient("[YOUR_KEY_ID]", "[YOUR_KEY_SECRET]");
//        JSONObject paymentLinkRequest = new JSONObject();
//        paymentLinkRequest.put("amount", 1000); // 10.00
//        paymentLinkRequest.put("currency","INR");
////        paymentLinkRequest.put("accept_partial",true);
////        paymentLinkRequest.put("first_min_partial_amount",100);
//        paymentLinkRequest.put("expire_by", 1715396752); //Epoch format
//        paymentLinkRequest.put("reference_id", orderId.toString());
//        paymentLinkRequest.put("description","Payment for Scaler class - 11th May");
//        JSONObject customer = new JSONObject();
//        customer.put("name","Aman");
//        customer.put("contact","8130445128");
//        customer.put("email","me.aman.pr@gmail.com");
//        paymentLinkRequest.put("customer",customer);
//        JSONObject notify = new JSONObject();
//        notify.put("sms",true);
//        notify.put("email",true);
//        paymentLinkRequest.put("notify",notify);
//        paymentLinkRequest.put("reminder_enable",true);
//        JSONObject notes = new JSONObject();
//        notes.put("policy_name","Some Random Policy");
//        paymentLinkRequest.put("notes",notes);
//        paymentLinkRequest.put("callback_url","https://www.scaler.com/");
//        paymentLinkRequest.put("callback_method","get");
//
//        PaymentLink payment = razorpay.paymentLink.create(paymentLinkRequest);
//
//        return payment.toString();
//    }
//
//    @Override
//    public boolean validatePayment(Long orderId) {
//        return false;
//    }
//}

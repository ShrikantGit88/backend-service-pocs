package com.selflearning.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment-provider")
public class PaymentController {

    @GetMapping("/paynow/{price}")
    public String makePayment(@PathVariable int price) {
        return "Payment of "+ price +" is successful!";
    }
}

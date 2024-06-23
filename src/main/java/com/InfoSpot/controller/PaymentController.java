package com.InfoSpot.controller;

import com.InfoSpot.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    @Autowired
    private PaymentService paymentService;


    @GetMapping("seed/payment")
    public String seedPaymentTable()
    {
        paymentService.seedPayment();
        return "Done Seeding the database";
    }

}

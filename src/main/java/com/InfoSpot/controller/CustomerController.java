package com.InfoSpot.controller;

import com.InfoSpot.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;


    @GetMapping("seed/customer")
    public String seedCustomerTable()
    {
        customerService.seedCustomer();
        return "Done Seeding the database";
    }

}

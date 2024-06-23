package com.InfoSpot.controller;

import com.InfoSpot.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressController {

    @Autowired
    private AddressService addressService;


    @GetMapping("seed/address")
    public String seedAddressTable()
    {
        addressService.seedAddress();
        return "Done Seeding the database";
    }

}

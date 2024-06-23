package com.InfoSpot.controller;

import com.InfoSpot.service.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RentalController {

    @Autowired
    private RentalService rentalService;


    @GetMapping("seed/rental")
    public String seedRentalTable()
    {
        rentalService.seedRental();
        return "Done Seeding the database";
    }

}

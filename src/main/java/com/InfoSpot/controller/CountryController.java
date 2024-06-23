package com.InfoSpot.controller;

import com.InfoSpot.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryController {

    @Autowired
    private CountryService countryService;


    @GetMapping("seed/country")
    public String seedCountryTable()
    {
        countryService.seedCountry();
        return "Done Seeding the database";
    }

}

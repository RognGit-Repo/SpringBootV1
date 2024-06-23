package com.InfoSpot.controller;

import com.InfoSpot.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CityController {

    @Autowired
    private CityService cityService;


    @GetMapping("seed/city")
    public String seedCityTable()
    {
        cityService.seedCity();
        return "Done Seeding the database";
    }

}

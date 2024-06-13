package com.InfoSpot.controller;

import com.InfoSpot.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;


    @GetMapping("test")
    public String test()
    {
        productService.seedProduct();
        return "Done Seeding the database";
    }

}

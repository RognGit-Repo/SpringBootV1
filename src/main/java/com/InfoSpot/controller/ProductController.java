package com.InfoSpot.controller;

import com.InfoSpot.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {



    @GetMapping("test")
    public String test()
    {
        return "Hello World";
    }

}

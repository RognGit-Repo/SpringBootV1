package com.InfoSpot.controller;

import com.InfoSpot.service.ActorService;
import com.InfoSpot.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @Autowired
    private ActorService actorService;


    @GetMapping("seed/actor")
    public String seedActorTable()
    {
        actorService.seedActor();
        return "Done Seeding the database";
    }

}

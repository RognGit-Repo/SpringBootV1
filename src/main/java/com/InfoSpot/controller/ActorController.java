package com.InfoSpot.controller;

import com.InfoSpot.entity.Actor;
import com.InfoSpot.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ActorController {

    @Autowired
    private ActorService actorService;


    @GetMapping("seed/actor")
    public String seedActorTable()
    {
        actorService.seedActor();
        return "Done Seeding the database";
    }

    @GetMapping("actor/getAll")
    public List<Actor> getAllActor()
    {
        return actorService.getAllActor();

    }

}

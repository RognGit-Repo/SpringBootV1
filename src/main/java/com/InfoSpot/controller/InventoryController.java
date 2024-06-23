package com.InfoSpot.controller;

import com.InfoSpot.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;


    @GetMapping("seed/inventory")
    public String seedInventoryTable()
    {
        inventoryService.seedInventory();
        return "Done Seeding the database";
    }

}

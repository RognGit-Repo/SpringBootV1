package com.InfoSpot.controller;

import com.InfoSpot.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StaffController {

    @Autowired
    private StaffService staffService;


    @GetMapping("seed/staff")
    public String seedStaffTable()
    {
        staffService.seedStaff();
        return "Done Seeding the database";
    }

}

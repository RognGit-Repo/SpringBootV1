package com.InfoSpot.controller;

import com.InfoSpot.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;


    @GetMapping("seed/category")
    public String seedCategoryTable()
    {
        categoryService.seedCategory();
        return "Done Seeding the database";
    }

}

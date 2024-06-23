package com.InfoSpot.controller;

import com.InfoSpot.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LanguageController {

    @Autowired
    private LanguageService languageService;


    @GetMapping("seed/language")
    public String seedLanguageTable()
    {
        languageService.seedLanguage();
        return "Done Seeding the database";
    }

}

package com.InfoSpot.controller;

import com.InfoSpot.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilmController {

    @Autowired
    private FilmService filmService;


    @GetMapping("seed/film")
    public String seedFilmTable()
    {
        filmService.seedFilm();
        return "Done Seeding the database";
    }

}

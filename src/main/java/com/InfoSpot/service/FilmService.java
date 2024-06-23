package com.InfoSpot.service;


import com.InfoSpot.repository.FilmRepository;
import jakarta.transaction.Transactional;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class FilmService {

    private JdbcTemplate jdbcTemplate;
    private FilmRepository filmRepository;

    //Target
    //1.create a constructor with dependecy injection (jdbctemplate and film repository)

    public FilmService(JdbcTemplate jdbcTemplate, FilmRepository filmRepository)
    {
        this.jdbcTemplate=jdbcTemplate;
        this.filmRepository=filmRepository;

    }

    //Target 2
    //Create a seed function for the film table
    public void seedFilm()
    {
        Object[] obj={"Ronald", "Ronald"};
        String QueryString="INSERT INTO film(first_name, last_name) VALUES(?,?)";
        jdbcTemplate.update(QueryString, obj);
    }
}
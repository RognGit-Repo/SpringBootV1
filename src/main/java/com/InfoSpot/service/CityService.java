package com.InfoSpot.service;


import com.InfoSpot.repository.CityRepository;
import jakarta.transaction.Transactional;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CityService {

    private JdbcTemplate jdbcTemplate;
    private CityRepository cityRepository;

    //Target
    //1.create a constructor with dependecy injection (jdbctemplate and city repository)

    public CityService(JdbcTemplate jdbcTemplate, CityRepository cityRepository)
    {
        this.jdbcTemplate=jdbcTemplate;
        this.cityRepository=cityRepository;

    }

    //Target 2
    //Create a seed function for the city table
    public void seedCity()
    {
        Object[] obj={"Ronald", "Ronald"};
        String QueryString="INSERT INTO city(first_name, last_name) VALUES(?,?)";
        jdbcTemplate.update(QueryString, obj);
    }
}
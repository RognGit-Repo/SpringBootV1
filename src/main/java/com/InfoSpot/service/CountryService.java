package com.InfoSpot.service;


import com.InfoSpot.repository.CountryRepository;
import jakarta.transaction.Transactional;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CountryService {

    private JdbcTemplate jdbcTemplate;
    private CountryRepository countryRepository;

    //Target
    //1.create a constructor with dependecy injection (jdbctemplate and country repository)

    public CountryService(JdbcTemplate jdbcTemplate, CountryRepository countryRepository)
    {
        this.jdbcTemplate=jdbcTemplate;
        this.countryRepository=countryRepository;

    }

    //Target 2
    //Create a seed function for the country table
    public void seedCountry()
    {
        Object[] obj={"Ronald", "Ronald"};
        String QueryString="INSERT INTO country(first_name, last_name) VALUES(?,?)";
        jdbcTemplate.update(QueryString, obj);
    }
}
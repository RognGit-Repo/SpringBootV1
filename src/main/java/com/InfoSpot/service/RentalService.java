package com.InfoSpot.service;


import com.InfoSpot.repository.RentalRepository;
import jakarta.transaction.Transactional;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RentalService {

    private JdbcTemplate jdbcTemplate;
    private RentalRepository rentalRepository;

    //Target
    //1.create a constructor with dependecy injection (jdbctemplate and rental repository)

    public RentalService(JdbcTemplate jdbcTemplate, RentalRepository rentalRepository)
    {
        this.jdbcTemplate=jdbcTemplate;
        this.rentalRepository=rentalRepository;

    }

    //Target 2
    //Create a seed function for the rental table
    public void seedRental()
    {
        Object[] obj={"Ronald", "Ronald"};
        String QueryString="INSERT INTO rental(first_name, last_name) VALUES(?,?)";
        jdbcTemplate.update(QueryString, obj);
    }
}
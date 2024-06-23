package com.InfoSpot.service;


import com.InfoSpot.repository.StoreRepository;
import jakarta.transaction.Transactional;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class StoreService {

    private JdbcTemplate jdbcTemplate;
    private StoreRepository storeRepository;

    //Target
    //1.create a constructor with dependecy injection (jdbctemplate and store repository)

    public StoreService(JdbcTemplate jdbcTemplate, StoreRepository storeRepository)
    {
        this.jdbcTemplate=jdbcTemplate;
        this.storeRepository=storeRepository;

    }

    //Target 2
    //Create a seed function for the store table
    public void seedStore()
    {
        Object[] obj={"Ronald", "Ronald"};
        String QueryString="INSERT INTO store(first_name, last_name) VALUES(?,?)";
        jdbcTemplate.update(QueryString, obj);
    }
}
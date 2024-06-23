package com.InfoSpot.service;


import com.InfoSpot.repository.AddressRepository;
import jakarta.transaction.Transactional;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class AddressService {

    private JdbcTemplate jdbcTemplate;
    private AddressRepository addressRepository;

    //Target
    //1.create a constructor with dependecy injection (jdbctemplate and address repository)

    public AddressService(JdbcTemplate jdbcTemplate, AddressRepository addressRepository)
    {
        this.jdbcTemplate=jdbcTemplate;
        this.addressRepository=addressRepository;

    }

    //Target 2
    //Create a seed function for the address table
    public void seedAddress()
    {
        Object[] obj={"Ronald", "Ronald"};
        String QueryString="INSERT INTO address(first_name, last_name) VALUES(?,?)";
        jdbcTemplate.update(QueryString, obj);
    }
}
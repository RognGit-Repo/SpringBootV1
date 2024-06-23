package com.InfoSpot.service;


import com.InfoSpot.repository.CustomerRepository;
import jakarta.transaction.Transactional;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CustomerService {

    private JdbcTemplate jdbcTemplate;
    private CustomerRepository customerRepository;

    //Target
    //1.create a constructor with dependecy injection (jdbctemplate and customer repository)

    public CustomerService(JdbcTemplate jdbcTemplate, CustomerRepository customerRepository)
    {
        this.jdbcTemplate=jdbcTemplate;
        this.customerRepository=customerRepository;

    }

    //Target 2
    //Create a seed function for the customer table
    public void seedCustomer()
    {
        Object[] obj={"Ronald", "Ronald"};
        String QueryString="INSERT INTO customer(first_name, last_name) VALUES(?,?)";
        jdbcTemplate.update(QueryString, obj);
    }
}
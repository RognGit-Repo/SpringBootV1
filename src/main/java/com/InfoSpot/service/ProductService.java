package com.InfoSpot.service;


import com.InfoSpot.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProductService {

    private JdbcTemplate jdbcTemplate;
    private ProductRepository productRepository;

    //Target
    //1.create a constructor with dependecy injection (jdbctemplate and product repository)

    public ProductService(JdbcTemplate jdbcTemplate, ProductRepository productRepository)
    {
        this.jdbcTemplate=jdbcTemplate;
        this.productRepository=productRepository;

    }

    //Target 2
    //Create a seed function for the product table
    public void seedProduct()
    {
        Object[] obj={"Ronald", "Ronald"};
        String QueryString="INSERT INTO product(first_name, last_name) VALUES(?,?)";
        jdbcTemplate.update(QueryString, obj);
    }
}
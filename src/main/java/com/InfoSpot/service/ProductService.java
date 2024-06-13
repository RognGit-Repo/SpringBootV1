package com.InfoSpot.service;

import com.InfoSpot.repository.ProductRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private ProductRepository productRepository;
    private JdbcTemplate jdbcTemplate;

    public ProductService(ProductRepository productRepository, JdbcTemplate jdbcTemplate)
    {
        this.productRepository=productRepository;
        this.jdbcTemplate=jdbcTemplate;
    }


    public void seedProduct()
    {
        Object[] data={"Rommel", "Reyes", "rm@gmail.com"};
        String sqlQuery="INSERT INTO products(first_name, last_name, email)\n" +
                "\n" +
                "VALUES(?, ?, ?)";
        jdbcTemplate.update(sqlQuery, data);

    }


}

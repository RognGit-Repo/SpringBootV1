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
//        Object[] data={"Ronald", "Reyes", "rn@gmail.com"};
//        String sqlQuery="INSERT INTO products(first_name, last_name, email)\n" +
//                "\n" +
//                "VALUES(?, ?, ?)";
//        jdbcTemplate.update(sqlQuery, data);

        Object[] data={"Ronald", "Reyes"};
        String sqlQuery="INSERT INTO actor(first_name, last_name)\n" +
                "\n" +
                "VALUES(?, ?)";
        jdbcTemplate.update(sqlQuery, data);

    }


}

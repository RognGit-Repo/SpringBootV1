package com.InfoSpot.service;


import com.InfoSpot.repository.CategoryRepository;
import jakarta.transaction.Transactional;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CategoryService {

    private JdbcTemplate jdbcTemplate;
    private CategoryRepository categoryRepository;

    //Target
    //1.create a constructor with dependecy injection (jdbctemplate and category repository)

    public CategoryService(JdbcTemplate jdbcTemplate, CategoryRepository categoryRepository)
    {
        this.jdbcTemplate=jdbcTemplate;
        this.categoryRepository=categoryRepository;

    }

    //Target 2
    //Create a seed function for the category table
    public void seedCategory()
    {
        Object[] obj={"Ronald", "Ronald"};
        String QueryString="INSERT INTO category(first_name, last_name) VALUES(?,?)";
        jdbcTemplate.update(QueryString, obj);
    }
}
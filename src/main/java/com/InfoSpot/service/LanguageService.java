package com.InfoSpot.service;


import com.InfoSpot.repository.LanguageRepository;
import jakarta.transaction.Transactional;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class LanguageService {

    private JdbcTemplate jdbcTemplate;
    private LanguageRepository languageRepository;

    //Target
    //1.create a constructor with dependecy injection (jdbctemplate and language repository)

    public LanguageService(JdbcTemplate jdbcTemplate, LanguageRepository languageRepository)
    {
        this.jdbcTemplate=jdbcTemplate;
        this.languageRepository=languageRepository;

    }

    //Target 2
    //Create a seed function for the language table
    public void seedLanguage()
    {
        Object[] obj={"Ronald", "Ronald"};
        String QueryString="INSERT INTO language(first_name, last_name) VALUES(?,?)";
        jdbcTemplate.update(QueryString, obj);
    }
}
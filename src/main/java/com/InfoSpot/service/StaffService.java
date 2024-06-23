package com.InfoSpot.service;


import com.InfoSpot.repository.StaffRepository;
import jakarta.transaction.Transactional;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class StaffService {

    private JdbcTemplate jdbcTemplate;
    private StaffRepository staffRepository;

    //Target
    //1.create a constructor with dependecy injection (jdbctemplate and staff repository)

    public StaffService(JdbcTemplate jdbcTemplate, StaffRepository staffRepository)
    {
        this.jdbcTemplate=jdbcTemplate;
        this.staffRepository=staffRepository;

    }

    //Target 2
    //Create a seed function for the staff table
    public void seedStaff()
    {
        Object[] obj={"Ronald", "Ronald"};
        String QueryString="INSERT INTO staff(first_name, last_name) VALUES(?,?)";
        jdbcTemplate.update(QueryString, obj);
    }
}
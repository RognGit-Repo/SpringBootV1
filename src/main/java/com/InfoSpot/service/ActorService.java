package com.InfoSpot.service;


import com.InfoSpot.repository.ActorRepository;
import jakarta.transaction.Transactional;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ActorService {

    private JdbcTemplate jdbcTemplate;
    private ActorRepository actorRepository;

    //Target
    //1.create a constructor with dependecy injection (jdbctemplate and actor repository)

    public ActorService(JdbcTemplate jdbcTemplate, ActorRepository actorRepository)
    {
        this.jdbcTemplate=jdbcTemplate;
        this.actorRepository=actorRepository;

    }

    //Target 2
    //Create a seed function for the actor table
    public void seedActor()
    {
        Object[] obj={"Ronald", "Ronald"};
        String QueryString="INSERT INTO actor(first_name, last_name) VALUES(?,?)";
        jdbcTemplate.update(QueryString, obj);
    }
}

package com.InfoSpot.service;


import com.InfoSpot.repository.InventoryRepository;
import jakarta.transaction.Transactional;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class InventoryService {

    private JdbcTemplate jdbcTemplate;
    private InventoryRepository inventoryRepository;

    //Target
    //1.create a constructor with dependecy injection (jdbctemplate and inventory repository)

    public InventoryService(JdbcTemplate jdbcTemplate, InventoryRepository inventoryRepository)
    {
        this.jdbcTemplate=jdbcTemplate;
        this.inventoryRepository=inventoryRepository;

    }

    //Target 2
    //Create a seed function for the inventory table
    public void seedInventory()
    {
        Object[] obj={"Ronald", "Ronald"};
        String QueryString="INSERT INTO inventory(first_name, last_name) VALUES(?,?)";
        jdbcTemplate.update(QueryString, obj);
    }
}
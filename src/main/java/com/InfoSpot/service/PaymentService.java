package com.InfoSpot.service;


import com.InfoSpot.repository.PaymentRepository;
import jakarta.transaction.Transactional;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PaymentService {

    private JdbcTemplate jdbcTemplate;
    private PaymentRepository paymentRepository;

    //Target
    //1.create a constructor with dependecy injection (jdbctemplate and payment repository)

    public PaymentService(JdbcTemplate jdbcTemplate, PaymentRepository paymentRepository)
    {
        this.jdbcTemplate=jdbcTemplate;
        this.paymentRepository=paymentRepository;

    }

    //Target 2
    //Create a seed function for the payment table
    public void seedPayment()
    {
        Object[] obj={"Ronald", "Ronald"};
        String QueryString="INSERT INTO payment(first_name, last_name) VALUES(?,?)";
        jdbcTemplate.update(QueryString, obj);
    }
}
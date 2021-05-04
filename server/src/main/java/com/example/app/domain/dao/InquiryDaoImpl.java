package com.example.app.domain.dao;

import com.example.app.domain.entity.Inquiry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class InquiryDaoImpl implements InquiryDao {
  
    private JdbcTemplate jdbcTemplate;
    
    @Autowired
    public InquiryDaoImpl(JdbcTemplate jdbcTemplate) {
      this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public void create(Inquiry inquiry) {
      jdbcTemplate.update("INSERT INTO inquiry (name, email, contents) VALUES (?, ?, ?)",
          inquiry.getName(), inquiry.getEmail(), inquiry.getContents()); 
    }
}
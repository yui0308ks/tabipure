package com.example.app.domain.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.example.app.domain.entity.Inquiry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
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

    public Inquiry findById(int id) {
      Map<String, Object> map = jdbcTemplate.queryForMap("SELECT * FROM inquiry WHERE id = ?", id);
      Inquiry inquiry = new Inquiry(null, null, null);
      inquiry.setId((int) map.get("id"));
      inquiry.setName((String) map.get("name"));
      inquiry.setEmail((String) map.get("email"));
      inquiry.setContents((String) map.get("contents"));
      inquiry.setCreated(((Timestamp) map.get("created")).toLocalDateTime());
      return inquiry;
    }

    public  List<Inquiry> getAll() {
      List<Inquiry> inquirys = new ArrayList<>();
      for (Map<String, Object> row : jdbcTemplate.queryForList("SELECT * FROM inquiry ORDER BY id")) {
        Inquiry inquiry = new Inquiry();
        inquiry.setId((int) row.get("id"));
        inquiry.setName((String) row.get("name"));
        inquiry.setEmail((String) row.get("email"));
        inquiry.setContents((String) row.get("contents"));
        inquiry.setCreated(((Timestamp) row.get("created")).toLocalDateTime());
        inquirys.add(inquiry);
      }
      return inquirys;
    }

    public void delete(int id) {
      jdbcTemplate.update("DELETE  FROM inquiry WHERE id = ?", id);
    }
}
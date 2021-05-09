package com.example.app.domain.service;

import java.util.List;

import com.example.app.domain.dao.InquiryDao;
import com.example.app.domain.entity.Inquiry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InquiryServiceImpl implements InquiryService {
  
  public InquiryDao dao;
  
  @Autowired
  public InquiryServiceImpl(InquiryDao dao) {
    this.dao = dao;
  }

  @Override
  public void save(Inquiry inquiry) {
    dao.create(inquiry);
  }

  public List<Inquiry> getAll() {
    return dao.getAll();
  }

  public Inquiry findById(int id) {
    return dao.findById(id);
  }

  public void delete(int id) {
    dao.delete(id);
  }

  public void update(Inquiry inquiry) {
    dao.update(inquiry);
  }
}

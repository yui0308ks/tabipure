package com.example.app.domain.service;

import com.example.app.domain.dao.InquiryDao;
import com.example.app.domain.entity.Inquiry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InquiryServiceImpl implements InquiryService {
  
  private InquiryDao dao;
  
//   public InquiryServiceImpl(InquiryDao dao) {
//     this.dao = dao;
//   }
  @Override
  public void save(Inquiry inquiry) {
    dao.create(inquiry);
  }
}

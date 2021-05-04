package com.example.app.domain.dao;

import com.example.app.domain.entity.Inquiry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public interface InquiryDao {
    void create(Inquiry inquiry);
}
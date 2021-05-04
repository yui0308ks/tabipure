package com.example.app.domain.service;

import com.example.app.domain.entity.Inquiry;

import org.springframework.stereotype.Service;

@Service
public interface InquiryService {
    void save(Inquiry inquiry);
}

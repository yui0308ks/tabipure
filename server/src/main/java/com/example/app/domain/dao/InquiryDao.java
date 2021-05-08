package com.example.app.domain.dao;

import java.util.List;

import com.example.app.domain.entity.Inquiry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public interface InquiryDao {
    void create(Inquiry inquiry);

    List<Inquiry> getAll();

    Inquiry findById(int id);

    void delete(int id);

    void update(Inquiry inquiry);
}
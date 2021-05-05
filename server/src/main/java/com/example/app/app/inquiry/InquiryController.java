package com.example.app.app.inquiry;

import com.example.app.domain.entity.Inquiry;
import com.example.app.domain.service.InquiryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/inquiry")
public class InquiryController {

  @Autowired
  private InquiryService service;
  
  @GetMapping
  public String form(InquiryForm inquiryForm) {
    return "inquiry/index.html";
  }

  @PostMapping("/confirm")
  public String confirm(@Validated InquiryForm inquiryForm, BindingResult result) {
    if (result.hasErrors()) {
      return "inquiry/index.html";
    }
    return "inquiry/confirm.html";
  }

  @PostMapping("/save")
  public String save(@Validated InquiryForm inquiryForm, BindingResult result) {
    if (result.hasErrors()) {
      //TODO Exception
    }
    Inquiry inquiry = new Inquiry(inquiryForm.getName(), inquiryForm.getEmail(), inquiryForm.getContents());
    System.out.println(inquiry);
    service.save(inquiry);
    return "inquiry/complete.html";
  }
}
package com.example.app.app.inquiry;

import com.example.app.domain.entity.Inquiry;
import com.example.app.domain.service.InquiryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    System.out.println("name");
    System.out.println(inquiry.getName());
    service.save(inquiry);
    return "inquiry/complete.html";
  }

  @GetMapping("/list")
  public String list(Model model) {
    model.addAttribute("inquirys", service.getAll());
    System.out.println(model.addAttribute("inquirys", service.getAll()));
    return "inquiry/list.html";
  }

  @GetMapping("/detail/{id}")
  public String detail(@PathVariable("id") int id, Model model) {
    model.addAttribute("inquiry", service.findById(id));
    return "inquiry/detail.html";
  }

  @PostMapping("/delete")
  public String detail(@RequestParam("id") int id) {
    service.delete(id);
    return "redirect:/inquiry/list";
  }
}
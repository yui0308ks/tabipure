package com.example.app.domain.entity;

import java.time.LocalDateTime;

public class Inquiry {
    private int id;
    private String name;
    private String email;
    private String contents;
    private LocalDateTime created;
    
    public Inquiry(String name, String email, String contents) {
    }
    public String getName(){
        return name;
    }
    public String getEmail(){
    return email;
    }
    public String getContents(){
    return contents;
    }
    public void setName(String name){
    this.name = name;
    }
    public void setEmail(String email){
    this.email = email;
    }
    public void setContents(String contents){
    this.contents = contents;
    }
  }
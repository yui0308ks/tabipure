package com.example.app.app.inquiry.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomControllerAdvice {
  @ExceptionHandler({MemoException.class})
  public String handleException(MemoException e) {
    System.out.println("customController!");
    return "inquiry/error.html";
  }
  public static class MemoException extends RuntimeException {}
}
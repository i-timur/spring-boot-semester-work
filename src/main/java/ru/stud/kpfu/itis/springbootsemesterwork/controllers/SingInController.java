package ru.stud.kpfu.itis.springbootsemesterwork.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.security.PermitAll;

@Controller
public class SingInController {
  @PermitAll
  @GetMapping("/login")
  public String getLoginPage() {
    return "login_page";
  }
}

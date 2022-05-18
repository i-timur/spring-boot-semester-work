package ru.stud.kpfu.itis.springbootsemesterwork.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.stud.kpfu.itis.springbootsemesterwork.dto.UserForm;
import ru.stud.kpfu.itis.springbootsemesterwork.services.SignUpService;

import javax.annotation.security.PermitAll;

@Controller
public class SignUpController {

  @Autowired
  private SignUpService signUpService;

  @PermitAll
  @GetMapping("/signUp")
  public String getSignUpPage() {
    return "register_page";
  }

  @PermitAll
  @PostMapping("/signUp")
  public String signUp(UserForm form) {
    signUpService.signUp(form);
    return "redirect:/login";
  }
}

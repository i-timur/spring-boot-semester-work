package ru.stud.kpfu.itis.springbootsemesterwork.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.stud.kpfu.itis.springbootsemesterwork.dto.ProfileForm;
import ru.stud.kpfu.itis.springbootsemesterwork.models.User;
import ru.stud.kpfu.itis.springbootsemesterwork.repositories.UsersRepository;

@Controller
public class ProfileController {

  @Autowired
  private UsersRepository usersRepository;

  @PreAuthorize("isAuthenticated()")
  @GetMapping("/profile")
  public String getProfilePage(Authentication authentication, Model model) {
    User user = usersRepository.findByName(authentication.getName()).get();
    model.addAttribute("username", authentication.getName());
    model.addAttribute("firstName", user.getFirstName());
    model.addAttribute("lastName", user.getLastName());
    return "profile_page";
  }

  @PreAuthorize("isAuthenticated()")
  @PostMapping("/profile")
  public String updateProfile(Authentication authentication, ProfileForm form) {
    User user = usersRepository.findByName(authentication.getName()).get();
    user.setFirstName(form.getFirstName());
    user.setLastName(form.getLastName());
    usersRepository.save(user);
    return "redirect:/profile";
  }
}

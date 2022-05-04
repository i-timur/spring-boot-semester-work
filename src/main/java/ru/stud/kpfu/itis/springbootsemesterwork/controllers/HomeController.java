package ru.stud.kpfu.itis.springbootsemesterwork.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.stud.kpfu.itis.springbootsemesterwork.services.ArticlesService;
import ru.stud.kpfu.itis.springbootsemesterwork.services.CategoriesService;

@Controller
public class HomeController {

  @Autowired
  private ArticlesService articlesService;

  @Autowired
  private CategoriesService categoriesService;

  @GetMapping("/")
  public String getHomePage(Model model) {
    model.addAttribute("articlesList", articlesService.getAllArticles());
    model.addAttribute("categoriesList", categoriesService.getAllCategories());
    return "home_page";
  }
}

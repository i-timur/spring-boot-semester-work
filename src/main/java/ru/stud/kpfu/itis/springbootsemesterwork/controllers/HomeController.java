package ru.stud.kpfu.itis.springbootsemesterwork.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.stud.kpfu.itis.springbootsemesterwork.services.ArticlesService;
import ru.stud.kpfu.itis.springbootsemesterwork.services.CategoriesService;

import javax.annotation.security.PermitAll;


@Controller
public class HomeController {

  @Autowired
  private ArticlesService articlesService;

  @Autowired
  private CategoriesService categoriesService;

  @PermitAll
  @GetMapping("/")
  public String getHomePage(Authentication authentication, Model model) {
    model.addAttribute("articlesList", articlesService.getAllArticles());
    model.addAttribute("categoriesList", categoriesService.getAllCategories());
    if (authentication != null) {
      model.addAttribute("username", authentication.getName());
    }
    return "home_page";
  }

  @PermitAll
  @GetMapping("/article")
  public String getArticlePage(Authentication authentication, @RequestParam Long id, Model model) {
    model.addAttribute("article", articlesService.getById(id));
    if (authentication != null) {
      model.addAttribute("username", authentication.getName());
    }
    return "article_page";
  }
}

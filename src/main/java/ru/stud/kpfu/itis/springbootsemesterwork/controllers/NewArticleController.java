package ru.stud.kpfu.itis.springbootsemesterwork.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.stud.kpfu.itis.springbootsemesterwork.dto.ArticleForm;
import ru.stud.kpfu.itis.springbootsemesterwork.services.ArticlesService;
import ru.stud.kpfu.itis.springbootsemesterwork.services.CategoriesService;

@Controller
public class NewArticleController {

  @Autowired
  private ArticlesService articlesService;

  @Autowired
  private CategoriesService categoriesService;

  @PreAuthorize("hasAuthority('ADMIN')")
  @PostMapping("/create")
  public String createNewArticle(Authentication authentication, ArticleForm form, Model model) {
    articlesService.save(form, authentication.getName());
    return "redirect:/";
  }

  @PreAuthorize("hasAuthority('ADMIN')")
  @GetMapping("/create")
  public String getCreatePage(Authentication authentication, Model model) {
    model.addAttribute("username", authentication.getName());
    model.addAttribute("categoriesList", categoriesService.getAllCategories());
    return "create_page";
  }
}

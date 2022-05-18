package ru.stud.kpfu.itis.springbootsemesterwork.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.stud.kpfu.itis.springbootsemesterwork.dto.ArticleDto;
import ru.stud.kpfu.itis.springbootsemesterwork.dto.CategoryDto;
import ru.stud.kpfu.itis.springbootsemesterwork.services.ArticlesService;
import ru.stud.kpfu.itis.springbootsemesterwork.services.CategoriesService;

import javax.annotation.security.PermitAll;
import java.util.List;
import java.util.Optional;

@Controller
@RestController
public class ArticlesController {

  @Autowired
  private ArticlesService articlesService;

  @Autowired
  private CategoriesService categoriesService;

  @PermitAll
  @GetMapping("/articles")
  public List<ArticleDto>
    getArticles(@RequestParam Optional<Long> categoryId, @RequestParam Optional<String> searchTerm) {
    if (categoryId.isPresent() && searchTerm.isPresent()) {
      return articlesService.getAllBySearchTermAndCategory(searchTerm.get(), categoriesService.getById(categoryId.get()));
    } else if (categoryId.isPresent()) {
      return articlesService.getAllByCategory(categoriesService.getById(categoryId.get()));
    } else if (searchTerm.isPresent()) {
      return articlesService.getAllBySearchTerm(searchTerm.get());
    }
    return articlesService.getAllArticles();
  }
}

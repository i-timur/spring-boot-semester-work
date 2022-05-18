package ru.stud.kpfu.itis.springbootsemesterwork.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.stud.kpfu.itis.springbootsemesterwork.dto.ArticleForm;
import ru.stud.kpfu.itis.springbootsemesterwork.models.User;
import ru.stud.kpfu.itis.springbootsemesterwork.repositories.UsersRepository;
import ru.stud.kpfu.itis.springbootsemesterwork.services.ArticlesService;
import ru.stud.kpfu.itis.springbootsemesterwork.services.CategoriesService;

@Controller
public class NewArticleController {

  @Autowired
  private ArticlesService articlesService;

  @Autowired
  private CategoriesService categoriesService;

  @Autowired
  private UsersRepository usersRepository;

  @PreAuthorize("hasAuthority('ADMIN')")
  @PostMapping("/create")
  public String createNewArticle(Authentication authentication, ArticleForm form, Model model) {
    articlesService.save(form, authentication.getName());
    System.out.println(form.getCategoryIds().toString());
    return "redirect:/";
  }

  @GetMapping("/create")
  public String getCreatePage(Authentication authentication, Model model) {
    if (authentication != null) {
      User user = usersRepository.findByName(authentication.getName()).get();
      if (user.getRole() == User.Role.ADMIN) {
        model.addAttribute("username", authentication.getName());
        model.addAttribute("categoriesList", categoriesService.getAllCategories());
        return "create_page";
      }
    }

    return "redirect:/?noAccess";
  }
}

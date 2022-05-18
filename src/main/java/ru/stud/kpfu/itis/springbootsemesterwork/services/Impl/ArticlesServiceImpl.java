package ru.stud.kpfu.itis.springbootsemesterwork.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.stud.kpfu.itis.springbootsemesterwork.dto.ArticleDto;
import ru.stud.kpfu.itis.springbootsemesterwork.dto.ArticleForm;
import ru.stud.kpfu.itis.springbootsemesterwork.dto.CategoryDto;
import ru.stud.kpfu.itis.springbootsemesterwork.models.Article;
import ru.stud.kpfu.itis.springbootsemesterwork.models.Category;
import ru.stud.kpfu.itis.springbootsemesterwork.repositories.ArticlesRepository;
import ru.stud.kpfu.itis.springbootsemesterwork.repositories.CategoriesRepository;
import ru.stud.kpfu.itis.springbootsemesterwork.repositories.UsersRepository;
import ru.stud.kpfu.itis.springbootsemesterwork.security.details.UserDetailsImpl;
import ru.stud.kpfu.itis.springbootsemesterwork.security.details.UserDetailsServiceImpl;
import ru.stud.kpfu.itis.springbootsemesterwork.services.ArticlesService;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import static ru.stud.kpfu.itis.springbootsemesterwork.dto.ArticleDto.*;

@Component
public class ArticlesServiceImpl implements ArticlesService {

  @Autowired
  private ArticlesRepository articlesRepository;

  @Autowired
  private CategoriesRepository categoriesRepository;

  @Autowired
  private UsersRepository usersRepository;

  @Override
  public ArticleDto getById(Long id) {
    return ArticleDto.fromModel(articlesRepository.getById(id));
  }

  @Override
  public void save(ArticleForm form, String author) {
    List<Category> categories = form.getCategoryIds().stream().map((c) -> categoriesRepository.getById(c)).collect(Collectors.toList());
    Article newArticle = new Article(
      usersRepository.findByName(author).get(),
      form.getTitle(),
      form.getText(),
      categories
    );
    articlesRepository.save(newArticle);
    categories.stream().forEach((c) -> {
      c.getArticles().add(newArticle);
      categoriesRepository.save(c);

    });
  }

  @Override
  public List<ArticleDto> getAllArticles() {
    return fromModels(articlesRepository.findAll());
  }

  @Override
  public List<ArticleDto> getAllByCategory(CategoryDto category) {
    return fromModels(articlesRepository.findAllByCategories(
      categoriesRepository.getById(category.getId())));
  }

  @Override
  public List<ArticleDto> getAllBySearchTerm(String searchTerm) {
    return fromModels(articlesRepository.findAllByTitleContaining(searchTerm));
  }

  @Override
  public List<ArticleDto> getAllBySearchTermAndCategory(String searchTerm, CategoryDto category) {
    return fromModels(
     articlesRepository.findAllByTitleContainingAndCategories(searchTerm, categoriesRepository.getById(category.getId())));
  }
}

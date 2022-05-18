package ru.stud.kpfu.itis.springbootsemesterwork.services;

import ru.stud.kpfu.itis.springbootsemesterwork.dto.ArticleDto;
import ru.stud.kpfu.itis.springbootsemesterwork.dto.ArticleForm;
import ru.stud.kpfu.itis.springbootsemesterwork.dto.CategoryDto;

import java.util.List;

public interface ArticlesService {
  ArticleDto getById(Long id);
  void save(ArticleForm form, String author);
  List<ArticleDto> getAllArticles();
  List<ArticleDto> getAllByCategory(CategoryDto category);
  List<ArticleDto> getAllBySearchTerm(String searchTerm);
  List<ArticleDto> getAllBySearchTermAndCategory(String searchTerm, CategoryDto category);
}

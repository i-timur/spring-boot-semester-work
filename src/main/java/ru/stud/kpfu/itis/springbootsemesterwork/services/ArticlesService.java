package ru.stud.kpfu.itis.springbootsemesterwork.services;

import ru.stud.kpfu.itis.springbootsemesterwork.dto.ArticleDto;

import java.util.List;

public interface ArticlesService {
  List<ArticleDto> getAllArticles();
}

package ru.stud.kpfu.itis.springbootsemesterwork.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.stud.kpfu.itis.springbootsemesterwork.dto.ArticleDto;
import ru.stud.kpfu.itis.springbootsemesterwork.repositories.ArticlesRepository;
import ru.stud.kpfu.itis.springbootsemesterwork.services.ArticlesService;

import java.util.List;
import static ru.stud.kpfu.itis.springbootsemesterwork.dto.ArticleDto.*;

@Component
public class ArticlesServiceImpl implements ArticlesService {

  @Autowired
  private ArticlesRepository articlesRepository;

  @Override
  public List<ArticleDto> getAllArticles() {
    return fromModels(articlesRepository.findAll());
  }
}

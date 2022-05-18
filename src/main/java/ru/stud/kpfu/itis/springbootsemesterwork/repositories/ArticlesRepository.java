package ru.stud.kpfu.itis.springbootsemesterwork.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import ru.stud.kpfu.itis.springbootsemesterwork.models.Article;
import ru.stud.kpfu.itis.springbootsemesterwork.models.Category;

import java.util.List;

public interface ArticlesRepository extends JpaRepository<Article, Long> {
  List<Article> findAllByCategories(Category category);
  List<Article> findAllByTitleContaining(@Param("title") String title);
  List<Article> findAllByTitleContainingAndCategories(@Param("title") String title, Category category);
}

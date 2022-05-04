package ru.stud.kpfu.itis.springbootsemesterwork.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.stud.kpfu.itis.springbootsemesterwork.models.Article;

public interface ArticlesRepository extends JpaRepository<Article, Long> {
}

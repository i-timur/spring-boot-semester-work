package ru.stud.kpfu.itis.springbootsemesterwork.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.stud.kpfu.itis.springbootsemesterwork.models.Category;

import java.util.List;

public interface CategoriesRepository extends JpaRepository<Category, Long> {
  List<Category> getByName(String name);
}

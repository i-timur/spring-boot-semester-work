package ru.stud.kpfu.itis.springbootsemesterwork.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.stud.kpfu.itis.springbootsemesterwork.dto.CategoryDto;
import ru.stud.kpfu.itis.springbootsemesterwork.exceptions.CategoryNotFoundException;
import ru.stud.kpfu.itis.springbootsemesterwork.models.Category;
import ru.stud.kpfu.itis.springbootsemesterwork.repositories.CategoriesRepository;
import ru.stud.kpfu.itis.springbootsemesterwork.services.CategoriesService;

import java.util.List;
import static ru.stud.kpfu.itis.springbootsemesterwork.dto.CategoryDto.*;

@Component
public class CategoriesServiceImpl implements CategoriesService {

  @Autowired
  private CategoriesRepository categoriesRepository;

  @Override
  public List<CategoryDto> getAllCategories() {
    return fromModels(categoriesRepository.findAll());
  }

  @Override
  public CategoryDto getById(Long id) {
    Category category = categoriesRepository.findById(id)
      .orElseThrow(() ->
        new CategoryNotFoundException(String.format("Category with id equal to %s is not found", id)));
    return fromModel(category);
  }
}

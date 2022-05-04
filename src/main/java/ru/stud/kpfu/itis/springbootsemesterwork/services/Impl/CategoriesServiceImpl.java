package ru.stud.kpfu.itis.springbootsemesterwork.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.stud.kpfu.itis.springbootsemesterwork.dto.CategoryDto;
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
}

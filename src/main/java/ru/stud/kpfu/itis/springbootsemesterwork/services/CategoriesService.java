package ru.stud.kpfu.itis.springbootsemesterwork.services;

import ru.stud.kpfu.itis.springbootsemesterwork.dto.CategoryDto;

import java.util.List;

public interface CategoriesService {
  List<CategoryDto> getAllCategories();
}

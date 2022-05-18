package ru.stud.kpfu.itis.springbootsemesterwork.dto;

import ru.stud.kpfu.itis.springbootsemesterwork.models.Category;

import java.util.List;
import java.util.stream.Collectors;

public class CategoryDto {
  private Long id;
  private String name;

  public CategoryDto(Long id, String name) {
    this.id = id;
    this.name = name;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public static CategoryDto fromModel(Category category) {
    return new CategoryDto(category.getId(), category.getName());
  }

  public static List<CategoryDto> fromModels(List<Category> categories) {
    return categories.stream().map(CategoryDto::fromModel).collect(Collectors.toList());
  }
}

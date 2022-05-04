package ru.stud.kpfu.itis.springbootsemesterwork.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.stud.kpfu.itis.springbootsemesterwork.models.Category;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto {
  private Long id;
  private String name;

  public static CategoryDto fromModel(Category category) {
    return CategoryDto.builder()
      .id(category.getId())
      .name(category.getName())
      .build();
  }

  public static List<CategoryDto> fromModels(List<Category> categories) {
    return categories.stream().map(CategoryDto::fromModel).collect(Collectors.toList());
  }
}

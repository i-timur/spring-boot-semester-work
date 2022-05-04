package ru.stud.kpfu.itis.springbootsemesterwork.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.stud.kpfu.itis.springbootsemesterwork.models.Article;
import ru.stud.kpfu.itis.springbootsemesterwork.models.Category;
import ru.stud.kpfu.itis.springbootsemesterwork.models.User;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ArticleDto {
  private Long id;
  private User author;
  private String title;
  private String text;
  private List<Category> categories;
  private LocalDate publishDate;

  public static ArticleDto fromModel(Article article) {
    return ArticleDto.builder()
      .id(article.getId())
      .author(article.getAuthor())
      .title(article.getTitle())
      .text(article.getText())
      .categories(article.getCategories())
      .publishDate(article.getPublishDate())
      .build();
  }

  public static List<ArticleDto> fromModels(List<Article> articles) {
    return articles.stream().map(ArticleDto::fromModel).collect(Collectors.toList());
  }
}

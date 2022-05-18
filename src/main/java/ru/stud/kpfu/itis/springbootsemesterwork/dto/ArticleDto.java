package ru.stud.kpfu.itis.springbootsemesterwork.dto;

import ru.stud.kpfu.itis.springbootsemesterwork.models.Article;
import ru.stud.kpfu.itis.springbootsemesterwork.models.Category;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class ArticleDto {
  private Long id;
  private String author;
  private String title;
  private String text;
  private List<String> categories;
  private LocalDate publishDate;

  public ArticleDto(Long id, String author, String title, String text, List<String> categories, LocalDate publishDate) {
    this.id = id;
    this.author = author;
    this.title = title;
    this.text = text;
    this.categories = categories;
    this.publishDate = publishDate;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public List<String> getCategories() {
    return categories;
  }

  public void setCategories(List<String> categories) {
    this.categories = categories;
  }

  public LocalDate getPublishDate() {
    return publishDate;
  }

  public void setPublishDate(LocalDate publishDate) {
    this.publishDate = publishDate;
  }

  public static ArticleDto fromModel(Article article) {
    return new ArticleDto(
      article.getId(),
      article.getAuthor().getName(),
      article.getTitle(),
      article.getText(),
      article.getCategories().stream().map(Category::getName).collect(Collectors.toList()),
      article.getPublishDate()
    );
  }

  public static List<ArticleDto> fromModels(List<Article> articles) {
    return articles.stream().map(ArticleDto::fromModel).collect(Collectors.toList());
  }
}

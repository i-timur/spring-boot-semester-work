package ru.stud.kpfu.itis.springbootsemesterwork.dto;

import java.util.List;

public class ArticleForm {
  private String title;
  private String text;
  private List<Long> categoryIds;

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

  public List<Long> getCategoryIds() {
    return categoryIds;
  }

  public void setCategoryIds(List<Long> categoryIds) {
    this.categoryIds = categoryIds;
  }
}

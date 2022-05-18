package ru.stud.kpfu.itis.springbootsemesterwork.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Category {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  @ManyToMany()
  @JoinTable(name = "category_article",
    joinColumns = {@JoinColumn(name = "category_id", referencedColumnName = "id")},
    inverseJoinColumns = {@JoinColumn(name = "article_id", referencedColumnName = "id")})
  private List<Article> articles;

  public Category() {
  }

  public Category(Long id, String name, List<Article> articles) {
    this.id = id;
    this.name = name;
    this.articles = articles;
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

  public List<Article> getArticles() {
    return articles;
  }

  public void setArticles(List<Article> articles) {
    this.articles = articles;
  }
}

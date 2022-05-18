package ru.stud.kpfu.itis.springbootsemesterwork.models;

import javax.persistence.*;

@Entity
public class Comment {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "author_id", referencedColumnName = "id")
  private User author;

  @ManyToOne
  @JoinColumn(name = "article_id", referencedColumnName = "id")
  private Article article;

  public Comment() {
  }

  public Comment(Long id, User author, Article article) {
    this.id = id;
    this.author = author;
    this.article = article;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public User getAuthor() {
    return author;
  }

  public void setAuthor(User author) {
    this.author = author;
  }

  public Article getArticle() {
    return article;
  }

  public void setArticle(Article article) {
    this.article = article;
  }
}

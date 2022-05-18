package ru.stud.kpfu.itis.springbootsemesterwork.models;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Article {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne()
  @JoinColumn(name = "author_id", referencedColumnName = "id")
  private User author;

  private String title;

  private String text;

  @ManyToMany(mappedBy = "articles")
  private List<Category> categories;

  private LocalDate publishDate;

  @OneToMany(mappedBy = "article")
  private List<Comment> comments;

  public Article() {
  }

  public Article(User author, String title, String text) {
    this.author = author;
    this.title = title;
    this.text = text;
  }

  public Article(User author, String title, String text, List<Category> categories) {
    this.author = author;
    this.title = title;
    this.text = text;
    this.categories = categories;
  }

  public Article(Long id, User author, String title, String text, List<Category> categories, LocalDate publishDate, List<Comment> comments) {
    this.id = id;
    this.author = author;
    this.title = title;
    this.text = text;
    this.categories = categories;
    this.publishDate = publishDate;
    this.comments = comments;
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

  public List<Category> getCategories() {
    return categories;
  }

  public void setCategories(List<Category> categories) {
    this.categories = categories;
  }

  public LocalDate getPublishDate() {
    return publishDate;
  }

  public void setPublishDate(LocalDate publishDate) {
    this.publishDate = publishDate;
  }

  public List<Comment> getComments() {
    return comments;
  }

  public void setComments(List<Comment> comments) {
    this.comments = comments;
  }
}

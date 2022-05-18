package ru.stud.kpfu.itis.springbootsemesterwork.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "account")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Enumerated(value = EnumType.STRING)
  private Role role;

  private String name;

  private String firstName;

  private String lastName;

  private String hashPassword;

  @OneToMany(mappedBy = "author")
  private List<Article> articles;

  @OneToMany(mappedBy = "author")
  private List<Comment> comments;

  public User() {
  }

  public User(String name, String hashPassword, Role role) {
    this.name = name;
    this.hashPassword = hashPassword;
    this.role = role;
  }

  public User(Long id, Role role, String name, String hashPassword, List<Article> articles, List<Comment> comments) {
    this.id = id;
    this.role = role;
    this.name = name;
    this.hashPassword = hashPassword;
    this.articles = articles;
    this.comments = comments;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Role getRole() {
    return role;
  }

  public void setRole(Role role) {
    this.role = role;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getHashPassword() {
    return hashPassword;
  }

  public void setHashPassword(String password) {
    this.hashPassword = password;
  }

  public List<Article> getArticles() {
    return articles;
  }

  public void setArticles(List<Article> articles) {
    this.articles = articles;
  }

  public List<Comment> getComments() {
    return comments;
  }

  public void setComments(List<Comment> comments) {
    this.comments = comments;
  }

  public enum Role {
    USER, ADMIN
  }

  public boolean isAdmin() {
    return this.role == Role.ADMIN;
  }
}

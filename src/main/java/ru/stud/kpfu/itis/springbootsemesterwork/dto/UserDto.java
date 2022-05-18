package ru.stud.kpfu.itis.springbootsemesterwork.dto;

import ru.stud.kpfu.itis.springbootsemesterwork.models.Article;
import ru.stud.kpfu.itis.springbootsemesterwork.models.Comment;
import ru.stud.kpfu.itis.springbootsemesterwork.models.User;

import java.util.List;
import java.util.stream.Collectors;

public class UserDto {
  private Long id;
  private String name;
  private String password;
  private List<Long> articleIds;
  private List<Long> commentIds;

  public UserDto(Long id, String name, String password, List<Long> articleIds, List<Long> commentIds) {
    this.id = id;
    this.name = name;
    this.password = password;
    this.articleIds = articleIds;
    this.commentIds = commentIds;
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

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public List<Long> getArticleIds() {
    return articleIds;
  }

  public void setArticleIds(List<Long> articleIds) {
    this.articleIds = articleIds;
  }

  public List<Long> getCommentIds() {
    return commentIds;
  }

  public void setCommentIds(List<Long> commentIds) {
    this.commentIds = commentIds;
  }

  public static UserDto fromModel(User user) {
    return new UserDto(
      user.getId(),
      user.getName(),
      user.getHashPassword(),
      user.getArticles().stream().map(Article::getId).collect(Collectors.toList()),
      user.getComments().stream().map(Comment::getId).collect(Collectors.toList())
    );
  }
}

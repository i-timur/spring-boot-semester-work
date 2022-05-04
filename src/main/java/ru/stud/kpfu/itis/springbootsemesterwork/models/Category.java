package ru.stud.kpfu.itis.springbootsemesterwork.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
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
}

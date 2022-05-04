package ru.stud.kpfu.itis.springbootsemesterwork.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Article {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne()
  @JoinColumn(name = "author_id")
  private User author;

  private String title;

  private String text;

  @ManyToMany(mappedBy = "articles")
  private List<Category> categories;

  private LocalDate publishDate;
}

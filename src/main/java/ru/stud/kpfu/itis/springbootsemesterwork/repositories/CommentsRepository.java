package ru.stud.kpfu.itis.springbootsemesterwork.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.stud.kpfu.itis.springbootsemesterwork.models.Comment;

public interface CommentsRepository extends JpaRepository<Comment, Long> {
}

package ru.stud.kpfu.itis.springbootsemesterwork.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.stud.kpfu.itis.springbootsemesterwork.models.User;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<User, Long> {
  Optional<User> findByName(String name);

}

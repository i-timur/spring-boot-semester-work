package ru.stud.kpfu.itis.springbootsemesterwork.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.stud.kpfu.itis.springbootsemesterwork.dto.UserForm;
import ru.stud.kpfu.itis.springbootsemesterwork.models.User;
import ru.stud.kpfu.itis.springbootsemesterwork.repositories.UsersRepository;
import ru.stud.kpfu.itis.springbootsemesterwork.services.SignUpService;

@Component
public class SignUpServiceImpl implements SignUpService {

  @Autowired
  private UsersRepository usersRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  @Override
  public void signUp(UserForm form) {
    User newUser = new User(
      form.getName(),
      passwordEncoder.encode(form.getPassword()),
      User.Role.USER
    );
    usersRepository.save(newUser);
  }
}

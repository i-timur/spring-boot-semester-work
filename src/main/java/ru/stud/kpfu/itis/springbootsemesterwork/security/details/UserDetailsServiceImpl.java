package ru.stud.kpfu.itis.springbootsemesterwork.security.details;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import ru.stud.kpfu.itis.springbootsemesterwork.models.User;
import ru.stud.kpfu.itis.springbootsemesterwork.repositories.UsersRepository;

@Component("customUserDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

  @Autowired
  private UsersRepository usersRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = usersRepository.findByName(username)
      .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    return new UserDetailsImpl(user);
  }
}

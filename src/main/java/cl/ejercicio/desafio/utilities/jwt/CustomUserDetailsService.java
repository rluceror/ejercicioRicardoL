package cl.ejercicio.desafio.utilities.jwt;

import cl.ejercicio.desafio.data.Repository;
import cl.ejercicio.desafio.data.dtos.User;
import cl.ejercicio.desafio.utilities.jwt.models.CustomUserDetails;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

@Component
public class CustomUserDetailsService implements UserDetailsService {

  private Repository users;

  public CustomUserDetailsService(Repository users) {
    this.users = users;
  }

  @Override
  public UserDetails loadUserByUsername(String username) {
    CustomUserDetails customUserDetails = null;

    final User user = users.findByEmail(username);
    if (user != null) {
      customUserDetails =
          new CustomUserDetails(user.getEmail(), user.getPassword(), user.getRoles());
    }

    return customUserDetails;
  }
}

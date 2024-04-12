package cl.ejercicio.desafio.utilities.jwt.exceptions;

import cl.ejercicio.desafio.data.Repository;
import cl.ejercicio.desafio.data.dtos.User;
import cl.ejercicio.desafio.utilities.AppConstant;
import cl.ejercicio.desafio.utilities.jwt.JwtTokenProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;

public class CustomLogoutHandler implements LogoutHandler, Serializable {

  private static final long serialVersionUID = -3409865897460953769L;

  private final transient JwtTokenProvider jwtTokenProvider;
  private final transient Repository repository;

  public CustomLogoutHandler(
      final JwtTokenProvider jwtTokenProvider, Repository repository) {
    this.repository = repository;
    this.jwtTokenProvider = jwtTokenProvider;
  }

  @Override
  public void logout(
      HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
    String tokenSearch = request.getHeader(AppConstant.NAME_TOKEN_SESSION);
    final User findEmail = repository.findUserByToken(tokenSearch);
    final String updateToken =
        jwtTokenProvider.revocateToken(
            jwtTokenProvider.getUsername(tokenSearch), findEmail.getRoles());
    repository.revocateToken(tokenSearch, updateToken);
  }
}

package cl.ejercicio.desafio;

import cl.ejercicio.desafio.usecases.dosignin.SignInUseCase;
import cl.ejercicio.desafio.usecases.dosignin.models.SignInRequest;
import cl.ejercicio.desafio.usecases.dosignin.models.SignInResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceFacade implements LogicService {


  private final SignInUseCase signInUseCase;

  @Autowired
  public ServiceFacade(
      final SignInUseCase signInUseCase
      ) {
    this.signInUseCase = signInUseCase;

  }

  @Override
  public SignInResponse doSignIn(final SignInRequest signInRequest) {

    return signInUseCase.doSignIn(signInRequest);
  }

}

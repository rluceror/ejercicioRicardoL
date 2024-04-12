package cl.ejercicio.desafio;

import cl.ejercicio.desafio.usecases.dosignin.models.SignInRequest;
import cl.ejercicio.desafio.usecases.dosignin.models.SignInResponse;

public interface LogicService {

  SignInResponse doSignIn(SignInRequest signInRequest);

}

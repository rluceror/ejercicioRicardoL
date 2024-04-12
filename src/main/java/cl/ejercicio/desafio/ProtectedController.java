package cl.ejercicio.desafio;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/protected")
public class ProtectedController {

  private final ServiceFacade srvServiceFacade;

  @Autowired
  public ProtectedController(final ServiceFacade ejServiceFacade) {
    this.srvServiceFacade = ejServiceFacade;
  }

}

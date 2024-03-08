package persona;

import org.springframework.stereotype.Service;

@Service
public class PersonaService {
  private PersonaRepository personaRepository;

  public void crearPersona(Persona person) {
    personaRepository.save(person);
  }
}

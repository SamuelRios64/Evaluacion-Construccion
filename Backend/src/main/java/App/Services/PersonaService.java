package App.Services;

import App.Entities.Persona;
import App.Entities.Usuario;
import App.Repositories.PersonaRepository;
import App.Repositories.UsuarioRepository;
import App.dto.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// Servicio de Persona
@Service
public class PersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Persona> findAllPersonas(){
        return personaRepository.findAll();
    }

    public Persona findByIdPersona(Long idPersona){
        return personaRepository.findById(idPersona).orElse(null);
    }

    public Persona savePersona(Persona persona){
        return personaRepository.save(persona);
    }

    public ResponseDTO deletePersona(Long idPersona) {

        Persona personaEliminar = findByIdPersona(idPersona);
        Boolean usuarioConPersona = usuarioRepository.existsByIdPersona(personaEliminar);

        if(!usuarioConPersona) {
            personaRepository.deleteById(idPersona);
            return new ResponseDTO("Persona con ID " + idPersona + " eliminada", true);
        }
        else {
            return new ResponseDTO("No se puede eliminar, usuario usando el ID " + idPersona, false);
        }
    }
}

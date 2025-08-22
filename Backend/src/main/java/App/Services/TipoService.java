package App.Services;

import App.Entities.Persona;
import App.Entities.Tipo;
import App.Repositories.PersonaRepository;
import App.Repositories.TipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoService {

    @Autowired
    private TipoRepository tipoRepository;

    public List<Tipo> findAllTipos(){
        return tipoRepository.findAll();
    }

    public Tipo findByIdTipo(Long idTipo){
        return tipoRepository.findById(idTipo).orElse(null);
    }

    public Tipo saveTipo(Tipo tipo){
        return tipoRepository.save(tipo);
    }

    public void deleteTipo(Long idTipo) {
        tipoRepository.deleteById(idTipo);
    }
}

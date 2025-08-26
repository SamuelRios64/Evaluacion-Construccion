package App.Services;

import App.Entities.Persona;
import App.Entities.Tipo;
import App.Entities.Usuario;
import App.Repositories.PersonaRepository;
import App.Repositories.TipoRepository;
import App.Repositories.UsuarioRepository;
import App.dto.PersonaDTO;
import App.dto.ResponseDTO;
import App.dto.TipoDTO;
import App.dto.UsuarioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

// Servicios para el Tipo
@Service
public class TipoService {

    // Repositorio de Lotes
    @Autowired
    private TipoRepository tipoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    // Buscar todos los lotes
    public List<TipoDTO> findAllTipos(){
        var tipos = tipoRepository.findAll();
        List<TipoDTO> tipoSeteados = new ArrayList<>();
        tipos.forEach(tipo -> {

            TipoDTO usuarioDto = new TipoDTO(
                    tipo.getIdTipo(),
                    tipo.getCargo());
            tipoSeteados.add(usuarioDto);
        });
        return tipoSeteados;
    }

    // Buscar tipo por ID
    public TipoDTO findByIdTipo(Long idTipo){
        Tipo tipo = tipoRepository.findById(idTipo).orElse(null);
        TipoDTO tipoDTO = new TipoDTO(
                tipo.getIdTipo(),
                tipo.getCargo());
        return tipoDTO;
    }

    // Guardar tipo
    public Tipo saveTipo(Tipo tipo){
        return tipoRepository.save(tipo);
    }

    public TipoDTO updateTipo(TipoDTO tipoDto) {

        Tipo tipoGuardar = new Tipo(tipoDto.getIdTipo(), tipoDto.getNombre());
        saveTipo(tipoGuardar);
        return tipoDto;
    }

    // Eliminar Tipo, siempre y cuando no esté referenciado o asociado a un Usuario
    public ResponseDTO deleteTipo(Long idTipo) {
        Tipo tipoEliminar = tipoRepository.findById(idTipo).orElse(null);
        Boolean usuarioConTipo= usuarioRepository.existsByIdTipo(tipoEliminar);

        if(!usuarioConTipo) {
            tipoRepository.deleteById(idTipo);
            return new ResponseDTO("Tipo con ID " + idTipo + " eliminado", true);
        }
        else {
            return new ResponseDTO("No se puede eliminar, usuario usando el ID " + idTipo, false);
        }
    }
}

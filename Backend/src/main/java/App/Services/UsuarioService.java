package App.Services;

import App.Entities.Persona;
import App.Entities.Usuario;
import App.Repositories.PersonaRepository;
import App.Repositories.UsuarioRepository;
import App.dto.PersonaDTO;
import App.dto.TipoDTO;
import App.dto.UsuarioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<UsuarioDTO> findAllUsuarios(){
        System.out.println("Antes de buscar usuarios");
        List<Usuario> usuarios = usuarioRepository.findAll();
        System.out.println("Usuarios: " + usuarios);

        List<UsuarioDTO> usuariosSeteados = new ArrayList<>();

        usuarios.forEach(usuario -> {
            TipoDTO tipoDto = new TipoDTO(usuario.getIdTipo().getIdTipo(), usuario.getIdTipo().getCargo());
            PersonaDTO personaDto = new PersonaDTO(usuario.getIdPersona().getIdPersona(), usuario.getIdPersona().getNombre(), usuario.getIdPersona().getApellido());
            UsuarioDTO usuarioDto = new UsuarioDTO(
                    usuario.getIdUsuario(),
                    usuario.getUsuario(),
                    usuario.getContraseña(),
                    tipoDto,
                    personaDto);
            usuariosSeteados.add(usuarioDto);
        });

        return usuariosSeteados;
    }

    public UsuarioDTO findByIdUsuario(Long idUsuario){

        Usuario usuario = usuarioRepository.findById(idUsuario).orElse(null);

        if (usuario == null) {
            return new UsuarioDTO();
        }

        TipoDTO tipoDto = new TipoDTO(usuario.getIdTipo().getIdTipo(), usuario.getIdTipo().getCargo());
        PersonaDTO personaDto = new PersonaDTO(usuario.getIdPersona().getIdPersona(), usuario.getIdPersona().getNombre(), usuario.getIdPersona().getApellido());
        UsuarioDTO usuarioDto = new UsuarioDTO(
                usuario.getIdUsuario(),
                usuario.getUsuario(),
                usuario.getContraseña(),
                tipoDto,
                personaDto);
        usuarioSeteados.add(usuarioDto);
        return usuarioRepository.findById(idUsuario).orElse(null);
    }

    public Usuario saveUsuario(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public void deleteUsuario(Long idUsuario) {
        usuarioRepository.deleteById(idUsuario);
    }
}

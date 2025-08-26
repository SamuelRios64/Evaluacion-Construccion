package App.Services;

import App.Entities.Persona;
import App.Entities.Tipo;
import App.Entities.Usuario;
import App.Repositories.PersonaRepository;
import App.Repositories.UsuarioRepository;
import App.dto.PersonaDTO;
import App.dto.ResponseDTO;
import App.dto.TipoDTO;
import App.dto.UsuarioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

// Servicio para Usuario
@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // Metodo para buscar todos los usuarios
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

    // Metodo para buscar un usaurio por ID
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
        return usuarioDto;
    }

    // Metodo para guardar un usuario
    public Usuario saveUsuario(UsuarioDTO usuarioDto){

        Tipo tipo = new Tipo(usuarioDto.getTipo().getIdTipo(), usuarioDto.getTipo().getNombre());
        Persona persona = new Persona(usuarioDto.getIdPersona().getId(), usuarioDto.getIdPersona().getNombre(), usuarioDto.getIdPersona().getApellido());
        Usuario usuario = new Usuario(
                usuarioDto.getIdUsuario(),
                tipo,
                usuarioDto.getUsuario(),
                usuarioDto.getContraseña(),
                persona);
        return usuarioRepository.save(usuario);
    }

    // Metodo para actualizar un usuario
    public Usuario updateUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    // Metodo para eliminar un usuario
    public ResponseDTO deleteUsuario(Long idUsuario) {
        usuarioRepository.deleteById(idUsuario);
        ResponseDTO response = new ResponseDTO("Usuario eliminadocon el ID: " + idUsuario, true);
        return response;
    }
}

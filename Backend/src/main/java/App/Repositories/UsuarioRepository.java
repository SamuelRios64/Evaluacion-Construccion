package App.Repositories;

import App.Entities.Persona;
import App.Entities.Tipo;
import App.Entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// Repositorio de Usuario
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findUsuarioByIdPersona(Persona idPersona);
    Boolean existsByIdPersona(Persona idPersona);
    List<Usuario> findUsuarioByIdUsuario(Long idUsuario);
    Boolean existsByIdTipo(Tipo tipoEliminar);
}

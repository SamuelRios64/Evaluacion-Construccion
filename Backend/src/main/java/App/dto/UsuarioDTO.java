package App.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {
    private Long idUsuario;
    private String usuario;
    private String Contraseña;
    private TipoDTO tipo;
    private PersonaDTO idPersona;
}

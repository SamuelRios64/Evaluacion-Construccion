package App.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Entidad de Usuario
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

    @Id
    private Long idUsuario;

    @OneToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "tipo",
                nullable = true,
                foreignKey = @ForeignKey(name = "fk_usuario_tipo"))
    private Tipo idTipo;
    private String usuario;
    private String contraseña;

    @OneToOne
    @JoinColumn(name = "idPersona", nullable = false)
    private Persona idPersona;
}

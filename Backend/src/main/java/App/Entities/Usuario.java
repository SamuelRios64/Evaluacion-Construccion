package App.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

    @Id
    private Long idUsuario;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "tipo",
                nullable = false,
                foreignKey = @ForeignKey(name = "fk_usuario_tipo"))
    private Tipo idTipo;
    private String usuario;
    private String contraseña;

    @OneToOne
    @JoinColumn(name = "idPersona")
    private Persona idPersona;
}

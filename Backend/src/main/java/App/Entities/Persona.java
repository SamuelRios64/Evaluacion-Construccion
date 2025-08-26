package App.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Entidad de Persona
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Persona {

    @Id
    private Long idPersona;
    private String nombre;
    private String apellido;
}
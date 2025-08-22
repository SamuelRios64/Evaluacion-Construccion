package App.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PersonaDTO {

    private Long id;
    private String nombre;
    private String apellido;
}

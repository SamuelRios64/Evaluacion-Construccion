package App.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class TipoDTO {
    private Long idTipo;
    private String nombre;
}

package App.Controllers;

import App.Entities.Tipo;
import App.Services.TipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// htto://localhost:8080/garras/api/v1/tipos
@RestController
@RequestMapping("/tipos")
@CrossOrigin(value = "http://localhost:5173")
public class TipoController {

    @Autowired
    private TipoService tipoService;

    @GetMapping
    public ResponseEntity<?> listarTipos(){
        return new ResponseEntity<>(tipoService.findAllTipos(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarTipoPorId(@PathVariable Long id) {
        return new ResponseEntity<>(tipoService.findByIdTipo(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> guardarTipo(@RequestBody Tipo tipo) {
        return new ResponseEntity<>(tipoService.saveTipo(tipo), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<?> actualizarTipo(@RequestBody Tipo tipo) {
        return new ResponseEntity<>(tipoService.saveTipo(tipo), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarTipo(@PathVariable Long id) {
        tipoService.deleteTipo(id);
        return new ResponseEntity<>("Tipo Eliminado con exito: " + id, HttpStatus.NO_CONTENT);
    }
}

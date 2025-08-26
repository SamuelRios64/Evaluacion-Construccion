package App.Controllers;

import App.Entities.Persona;
import App.Services.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// Controlador de Personas
@RestController
@RequestMapping("/personas")
@CrossOrigin(value = "http://localhost:5173")
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    @GetMapping
    public ResponseEntity<?> listarPersonas(){
        return new ResponseEntity<>(personaService.findAllPersonas(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPersonaPorId(@PathVariable Long id){
        return new ResponseEntity<>(personaService.findByIdPersona(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> guardarPersona(@RequestBody Persona persona) {
        return new ResponseEntity<>(personaService.savePersona(persona), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<?> actualizarPersona(@RequestBody Persona persona) {
        return new ResponseEntity<>(personaService.savePersona(persona), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarPersona(@PathVariable Long id) {
        return new ResponseEntity<>(personaService.deletePersona(id), HttpStatus.OK);
    }
}

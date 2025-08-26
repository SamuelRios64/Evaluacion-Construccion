package App.Controllers;

import App.Entities.Usuario;
import App.Services.UsuarioService;
import App.dto.UsuarioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// Controlador para Usuarios
@RestController
@RequestMapping("/usuarios")
@CrossOrigin(value = "http://localhost:5173")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<?> listarUsuarios(){
        return new ResponseEntity<>(usuarioService.findAllUsuarios(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarUsuarioPorId(@PathVariable Long id) {
        return new ResponseEntity<>(usuarioService.findByIdUsuario(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> guardarUsuario(@RequestBody UsuarioDTO usuario) {
        return new ResponseEntity<>(usuarioService.saveUsuario(usuario), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> actualizarUsuario(@RequestBody Usuario usuario) {
        return new ResponseEntity<>(usuarioService.updateUsuario(usuario), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarUsuario(@PathVariable Long id) {
        return new ResponseEntity<>(usuarioService.deleteUsuario(id), HttpStatus.NO_CONTENT);
    }

}

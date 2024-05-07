package taskmanager.controller;

import taskmanager.model.Usuario;
import taskmanager.service.UsuarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public List<Usuario> getUsuarios() {
        return usuarioService.getUsuarios();
    }

    @PostMapping
    public void registrarNuevoUsuario(@RequestBody Usuario usuario) {
        usuarioService.registrarNuevoUsuario(usuario);
    }

    @DeleteMapping("{idUsuario}")
    public void eliminarUsuario(@PathVariable("idUsuario") Integer id) {
        usuarioService.eliminarUsuario(id);
    }

    @PutMapping("{idUsuario}")
    public void actualizarUsuario(@PathVariable("idUsuario") Integer id, @RequestBody Usuario usuario) {
        usuarioService.actualizarUsuario(id, usuario);
    }
}

package com.clases;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
@RestController
@RequestMapping("api/v1/usuario")
public class Main {

    // Instancia del repositorio para interactuar con la base de datos
    private final RepositorioUsuario repositorioUsuario;

    public Main(RepositorioUsuario repositorioUsuario) {
        this.repositorioUsuario = repositorioUsuario;
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    // Para leer registros de datos GET
    @GetMapping
    public List<Usuario> getUsuarios() {
        return repositorioUsuario.findAll();
    }

    record RequestUsuario(String nombre, String email) {

    }

    // Para crear registros de datos POST
    @PostMapping
    public void registrarNuevoUsuario(@RequestBody RequestUsuario request) {

        Usuario nuevoUsuario = new Usuario();
        nuevoUsuario.setNombre(request.nombre);
        nuevoUsuario.setEmail(request.email);
        repositorioUsuario.save(nuevoUsuario);

    }

    @DeleteMapping("{idUsuario}")
    public void eliminarUsuario(@PathVariable("idUsuario") Integer id) {
        repositorioUsuario.deleteById(id);
    }

    @PutMapping("{idUsuario}")
    public void actualizarUsuario(@PathVariable("idUsuario") Integer id, @RequestBody RequestUsuario request) {

        Optional<Usuario> usuarioOptional = repositorioUsuario.findById(id);

        if (usuarioOptional.isPresent()) {
            Usuario usuario = usuarioOptional.get();
            usuario.setNombre(request.nombre);
            usuario.setEmail(request.email);
            repositorioUsuario.save(usuario);
        } else {
            throw new IllegalArgumentException("El usuario con ID " + id + " no existe");
        }

    }

}

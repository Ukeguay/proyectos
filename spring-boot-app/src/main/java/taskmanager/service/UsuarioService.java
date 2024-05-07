package taskmanager.service;

import taskmanager.model.Usuario;
import taskmanager.repository.RepositorioUsuario;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private final RepositorioUsuario repositorioUsuario;

    public UsuarioService(RepositorioUsuario repositorioUsuario) {
        this.repositorioUsuario = repositorioUsuario;
    }

    public List<Usuario> getUsuarios() {
        return repositorioUsuario.findAll();
    }

    public void registrarNuevoUsuario(Usuario usuario) {
        repositorioUsuario.save(usuario);
    }

    public void eliminarUsuario(Integer id) {
        repositorioUsuario.deleteById(id);
    }

    public void actualizarUsuario(Integer id, Usuario usuario) {
        Optional<Usuario> usuarioOptional = repositorioUsuario.findById(id);
        if (usuarioOptional.isPresent()) {
            Usuario usuarioExistente = usuarioOptional.get();
            usuarioExistente.setNombre(usuario.getNombre());
            usuarioExistente.setEmail(usuario.getEmail());
            repositorioUsuario.save(usuarioExistente);
        } else {
            throw new IllegalArgumentException("El usuario con ID " + id + " no existe");
        }
    }
}
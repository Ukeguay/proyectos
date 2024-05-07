package taskmanager.repository;

import taskmanager.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

// Define metodos para realizar operaciones CRUD en entidades Usuario utilizando Spring Data JPA
public interface RepositorioUsuario
        extends JpaRepository<Usuario, Integer> {
}

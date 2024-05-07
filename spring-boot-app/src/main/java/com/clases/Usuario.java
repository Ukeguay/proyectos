package com.clases;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Usuario {

    @Id
    // Crea secuencias en el campo id (por defecto: de 50 en 50)
    @SequenceGenerator(
            name = "secuencia",
            sequenceName = "secuencia",
            allocationSize = 1
    )
    // Genera valores en el campo id segun la @SequenceGenerator
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "secuencia"
    )
    private Integer id;
    private String nombre;
    private String password;

    public Usuario(Integer id, String nombre, String password) {
        this.id = id;
        this.nombre = nombre;
        this.password = password;
    }

    public Usuario() {
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(id, usuario.id) && Objects.equals(nombre, usuario.nombre) && Objects.equals(password, usuario.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, password);
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

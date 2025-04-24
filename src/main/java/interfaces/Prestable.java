package interfaces;

import entidades.Usuario;

import java.time.LocalDateTime;

public interface Prestable {
    boolean estaDisponible();
    void prestar(Usuario usuario);
    void devolver(Usuario usuario);
    LocalDateTime getFechaDevolucion();
    void setFechaDevolucion(LocalDateTime fechaDevolucion);
}

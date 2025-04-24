package entidades;

import interfaces.Prestable;

import java.time.LocalDateTime;

public abstract class RecursoPrestable extends RecursoDigital implements Prestable {
    private LocalDateTime fechaDevolucion;

    public RecursoPrestable(int id, String nombre, String autor, String genero, String fechaPublicacion, String estado) {
        super(id, nombre, autor, genero, fechaPublicacion, estado);
        this.fechaDevolucion = null;
    }

    public RecursoPrestable() {
        // Constructor vacío
    }

    public void prestar(Usuario usuario) {
        super.setEstado("prestado");
        usuario.agregarRecurso(this);
    }

    public void devolver(Usuario usuario) {
        super.setEstado("disponible");
        usuario.eliminarRecurso(this);
    }

    public boolean estaDisponible() {
        if (super.getEstado().equals("disponible")) {
            return true;
        } else {
            return false;
        }
    }

    public LocalDateTime getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(LocalDateTime fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }
}

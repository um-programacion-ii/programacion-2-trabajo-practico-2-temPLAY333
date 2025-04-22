package entidades;

import interfaces.Prestable;

public class Revista extends RecursoDigital implements Prestable {

    public Revista (int id, String nombre, String autor, String genero, String fechaPublicacion, String estado) {
        super(id, nombre, autor, genero, fechaPublicacion, estado);
    }

    public Revista () {
        // Constructor vacío
    }

    @Override
    public String tipoRecurso() {
        return "Revista";
    }

    public void prestar() {
        super.setEstado("prestado");
    }

    public void devolver() {
        super.setEstado("disponible");
    }

    public boolean estaDisponible() {
        if (super.getEstado().equals("disponible")) {
            return true;
        } else {
            return false;
        }
    }
}

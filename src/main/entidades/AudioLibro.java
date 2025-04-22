package entidades;

import interfaces.Prestable;
import interfaces.Renovable;
import excepciones.RecursoMaxRenovacionesExcepcion;

public class AudioLibro extends RecursoDigital implements Prestable, Renovable {
    private int vecesRenovado;

    public AudioLibro (int id, String nombre, String autor, String genero, String fechaPublicacion, String estado) {
        super(id, nombre, autor, genero, fechaPublicacion, estado);
        this.vecesRenovado = 0;
    }

    public AudioLibro () {
        // Constructor vacío
    }

    @Override
    public String tipoRecurso() {
        return "AudioLibro";
    }

    public void prestar() {
        super.setEstado("prestado");
    }

    public void devolver() {
        super.setEstado("disponible");
        this.vecesRenovado = 0;
    }

    public boolean estaDisponible() {
        if (super.getEstado().equals("disponible")) {
            return true;
        } else {
            return false;
        }
    }

    public void renovar() {
        if (vecesRenovado < 2) {
            vecesRenovado++;
        } else {
            throw new RecursoMaxRenovacionesExcepcion(super.getNombre());
        }
    }

    public int getVecesRenovado() {
        return vecesRenovado;
    }

    public void setVecesRenovado(int vecesRenovado) {
        this.vecesRenovado = vecesRenovado;
    }
}

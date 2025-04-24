package entidades;

import excepciones.RecursoMaxRenovacionesExcepcion;
import interfaces.Renovable;

public abstract class RecursoRenovable extends RecursoPrestable implements Renovable {
    private int vecesRenovado;

    public RecursoRenovable(int id, String nombre, String autor, String genero, String fechaPublicacion, String estado) {
        super(id, nombre, autor, genero, fechaPublicacion, estado);
        this.vecesRenovado = 0;
    }

    public RecursoRenovable() {
        // Constructor vacío
    }

    @Override
    public void devolver(Usuario usuario) {
        super.devolver(usuario);
        this.setVecesRenovado(0);
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
            System.out.println("Recurso renovado. Veces renovado: " + vecesRenovado);
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

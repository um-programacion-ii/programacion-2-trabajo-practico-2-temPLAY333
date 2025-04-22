package entidades;

public class Revista extends RecursoDigital{

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
}

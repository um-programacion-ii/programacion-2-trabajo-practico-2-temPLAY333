package entidades;

public class Libro extends RecursoDigital{

    public Libro (int id, String nombre, String autor, String genero, String fechaPublicacion, String estado) {
        super(id, nombre, autor, genero, fechaPublicacion, estado);
    }

    public Libro () {
        // Constructor vacío
    }

    @Override
    public String tipoRecurso() {
        return "Libro";
    }
}

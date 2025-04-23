package entidades;

public class AudioLibro extends RecursoRenovable {

    public AudioLibro (int id, String nombre, String autor, String genero, String fechaPublicacion, String estado) {
        super(id, nombre, autor, genero, fechaPublicacion, estado);
    }

    public AudioLibro () {
        // Constructor vacío
    }

    public String tipoRecurso() {
        return "AudioLibro";
    }
}

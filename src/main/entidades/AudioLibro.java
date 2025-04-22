package entidades;

public class AudioLibro extends RecursoDigital{

    public AudioLibro (int id, String nombre, String autor, String genero, String fechaPublicacion, String estado) {
        super(id, nombre, autor, genero, fechaPublicacion, estado);
    }

    public AudioLibro () {
        // Constructor vacío
    }

    @Override
    public String tipoRecurso() {
        return "AudioLibro";
    }
}

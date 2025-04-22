package entidades;

import interfaces.IRecursoDigital;

public abstract class RecursoDigital implements IRecursoDigital {
    private int id;
    private String nombre;
    private String autor;
    private String genero;
    private String fechaPublicacion;
    private String estado;

    public RecursoDigital(int id, String nombre, String autor, String genero, String fechaPublicacion, String estado) {
        this.id = id;
        this.nombre = nombre;
        this.autor = autor;
        this.genero = genero;
        this.fechaPublicacion = fechaPublicacion;
        this.estado = estado;
    }

    public String tipoRecurso() {
        return "digital";
    }

    public RecursoDigital() {
        // Constructor vacío
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(String fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}

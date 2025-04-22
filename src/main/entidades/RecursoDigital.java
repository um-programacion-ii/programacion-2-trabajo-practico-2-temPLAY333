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

    public void visualizar() {
        System.out.println("Visualizando recurso digital: " + this.nombre);
        System.out.println("Tipo de recurso: " + this.tipoRecurso());
        System.out.println("Estado: " + this.estado);
        System.out.println("Autor: " + this.autor);
        System.out.println("Género: " + this.genero);
        System.out.println("Fecha de publicación: " + this.fechaPublicacion);
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

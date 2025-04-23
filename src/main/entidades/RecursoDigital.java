package entidades;

import interfaces.IRecursoDigital;

public abstract class RecursoDigital implements IRecursoDigital {
    private int id;
    private String nombre;
    private String autor;
    private String categoria;
    private String fechaPublicacion;
    private String estado;

    public RecursoDigital(int id, String nombre, String autor, String categoria, String fechaPublicacion, String estado) {
        this.id = id;
        this.nombre = nombre;
        this.autor = autor;
        this.categoria = categoria;
        this.fechaPublicacion = fechaPublicacion;
        this.estado = estado;
    }

    public RecursoDigital() {
        // Constructor vacío
    }

    public String tipoRecurso() {
        return "digital";
    }

    public void visualizar() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Tipo de Recurso: " + tipoRecurso());
        System.out.println("Estado: " + estado);
        System.out.println("Autor: " + autor);
        System.out.println("Género: " + categoria);
        System.out.println("Fecha de Publicación: " + fechaPublicacion);
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

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
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

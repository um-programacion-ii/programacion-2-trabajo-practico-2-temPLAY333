package entidades;

import interfaces.IRecursoDigital;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class RecursoDigital implements IRecursoDigital {
    private int id;
    private String nombre;
    private String autor;
    private String categoria;
    private LocalDate fechaPublicacion;
    private String estado;

    public RecursoDigital(int id, String nombre, String autor, String categoria, String fechaPublicacion, String estado) {
        this.id = id;
        this.nombre = nombre;
        this.autor = autor;
        this.categoria = categoria;
        this.fechaPublicacion = LocalDate.parse(fechaPublicacion, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        this.estado = estado;
    }

    public RecursoDigital() {
        // Constructor vacío
    }

    public String tipoRecurso() {
        return "digital";
    }

    public void visualizar() {
        System.out.println(id + " - " + nombre + " - Autor: " + autor + " - Tipo: " + tipoRecurso() + " - (" + estado + ")");
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

    public LocalDate getFechaPublicacion(){
        return fechaPublicacion;
    }

    public void setFechaPublicacion(String fechaPublicacion) {
        this.fechaPublicacion = LocalDate.parse(fechaPublicacion, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}

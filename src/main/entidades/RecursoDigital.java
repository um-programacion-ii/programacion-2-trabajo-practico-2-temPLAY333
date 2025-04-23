package entidades;

import interfaces.IRecursoDigital;
import recursos.CategoriaRecurso;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class RecursoDigital implements IRecursoDigital {
    private int id;
    private String nombre;
    private String autor;
    private CategoriaRecurso categoria;
    private LocalDate fechaPublicacion;
    private String estado;

    public RecursoDigital(int id, String nombre, String autor, String categoria, String fechaPublicacion, String estado) {
        this.id = id;
        this.nombre = nombre;
        this.autor = autor;
        this.asignarCategoria(categoria);
        this.fechaPublicacion = LocalDate.parse(fechaPublicacion, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        this.estado = estado;
    }

    public RecursoDigital() {
        // Constructor vacío
        this.categoria = CategoriaRecurso.OTRO;
    }

    public String tipoRecurso() {
        return "digital";
    }

    public void visualizar() {
        System.out.println(id + " - " + nombre + " - Autor: " + autor + " - Tipo: " + tipoRecurso() + " - Género: " + getCategoria() + " - (" + estado + ")");
    }

    public void asignarCategoria(String categoriaStr) {
        this.categoria = CategoriaRecurso.fromString(categoriaStr);
    }

    public void asignarCategoria(CategoriaRecurso categoria) {
        this.categoria = categoria;
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
        return categoria.toString();
    }
    
    public CategoriaRecurso getCategoriaEnum() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.asignarCategoria(categoria);
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

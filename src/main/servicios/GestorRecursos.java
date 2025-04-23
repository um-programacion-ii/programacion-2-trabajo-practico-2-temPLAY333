package servicios;

import entidades.RecursoDigital;

import java.util.ArrayList;

public class GestorRecursos {
    private static GestorRecursos instance = null;
    private ArrayList<RecursoDigital> recursosDigitales = new ArrayList<>();;

    private GestorRecursos() {
    }

    public static GestorRecursos getInstance() {
        if (instance == null) {
            instance = new GestorRecursos();
        }
        return instance;
    }

    // Metodos de Busqueda para los Recursos Digitales
    public RecursoDigital buscarRecursoPorId(int id) {
        return recursosDigitales.stream()
                .filter(recurso -> recurso.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public RecursoDigital buscarRecursoPorNombre(String nombre) {
        return recursosDigitales.stream()
                .filter(recurso -> recurso.getNombre().equalsIgnoreCase(nombre))
                .findFirst()
                .orElse(null);
    }


    // Getters y Setters
    public ArrayList<RecursoDigital> getRecursosDigitales() {
        return this.recursosDigitales;
    }

    public void setRecursosDigitales (ArrayList<RecursoDigital> recursosDigitales) {
        this.recursosDigitales = recursosDigitales;
    }

    public void agregarRecurso(RecursoDigital recurso) {
        this.recursosDigitales.add(recurso);
    }

    public void eliminarRecurso(RecursoDigital recurso) {
        this.recursosDigitales.remove(recurso);
    }
}

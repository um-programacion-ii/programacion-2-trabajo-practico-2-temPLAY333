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

    public void createRecurso(RecursoDigital recurso) {
        // Lógica para crear un nuevo recurso digital
        System.out.println("Creando nuevo recurso: " + recurso.getNombre());
        // Aquí iría la lógica para guardar el recurso en una base de datos o lista
    }

    public void listarRecursos() {
        // Lógica para listar recursos digitales
        System.out.println("Listando recursos digitales...");
        // Aquí iría la lógica para recuperar y mostrar los recursos de una base de datos o lista
    }

    public void buscarRecurso() {
        // Lógica para buscar un recurso digital
        System.out.println("Buscando recurso digital...");
        // Aquí iría la lógica para buscar un recurso en una base de datos o lista
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

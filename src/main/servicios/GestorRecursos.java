package servicios;

import entidades.RecursoDigital;

public class GestorRecursos {
    private static GestorRecursos instance = null;

    private GestorRecursos() {
        // Constructor privado para evitar instanciación externa
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
}

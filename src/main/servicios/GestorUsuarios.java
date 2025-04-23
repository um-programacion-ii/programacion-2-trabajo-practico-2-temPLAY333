package servicios;

import entidades.Usuario;

import java.util.ArrayList;

public class GestorUsuarios {
    private static GestorUsuarios instance = null;

    private GestorUsuarios() {
        // Constructor privado para evitar instanciación externa
    }

    public static GestorUsuarios getInstance() {
        if (instance == null) {
            instance = new GestorUsuarios();
        }
        return instance;
    }

    public Usuario buscarUsuario(String nombre) {
        Usuario usuario = new Usuario();
        // Aquí se implementaría la lógica para buscar usuarios en la base de datos o en una lista
        // Por ahora, se devuelve una lista vacía
        return usuario;
    }
}

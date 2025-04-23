package servicios;

import entidades.Usuario;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GestorUsuarios {
    private static GestorUsuarios instance = null;
    private Map<String, Usuario> usuarios;

    private GestorUsuarios() {
        this.usuarios = new HashMap<>();
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

    // Métodos de búsqueda para los usuarios
    public Usuario buscarUsuarioPorId(int id) {
        return usuarios.values().stream()
                .filter(usuario -> usuario.getId() == id)
                .findFirst()
                .orElse(null);
    }

    // IA: Queria un sistema de busqueda de palabras parciales en el nombre o apellidos de los usuarios
    public Map<String, Usuario> buscarUsuariosCoincidentes(String busqueda) {
        Map<String, Usuario> resultados = new HashMap<>();
        String terminoBusqueda = busqueda.toLowerCase().trim();

        for (Map.Entry<String, Usuario> entrada : usuarios.entrySet()) {
            String nombreCompleto = entrada.getKey();
            Usuario usuario = entrada.getValue();
            String[] palabras = nombreCompleto.split(" ");

            // Verificar coincidencia exacta o al inicio de palabra
            for (String palabra : palabras) {
                String palabraLower = palabra.toLowerCase();
                if (palabraLower.equals(terminoBusqueda) ||
                        palabraLower.startsWith(terminoBusqueda)) {
                    resultados.put(nombreCompleto, usuario);
                    break;
                }
            }
        }

        return resultados;
    }


    // Getters y Setters
    public Map<String, Usuario> getUsuarios() {
        return this.usuarios;
    }

    public void setUsuarios(Map<String, Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public void agregarUsuario(Usuario usuario) {
        this.usuarios.put(usuario.getNombre(), usuario);
    }

    public void eliminarUsuario(String nombre) {
        this.usuarios.remove(nombre);
    }
}

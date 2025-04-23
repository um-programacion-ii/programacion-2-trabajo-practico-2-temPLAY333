package entidades;

import java.util.ArrayList;

public class Usuario {
    private int id;
    private String nombre;
    private String email;
    private String password;
    private ArrayList<RecursoDigital> recursosPrestados = new ArrayList<>();

    public Usuario(int id, String nombre, String email, String password) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.password = password;
    }

    public Usuario () {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<RecursoDigital> getRecursosPrestados() {
        return recursosPrestados;
    }

    public void setRecursosPrestados(ArrayList<RecursoDigital> recursosPrestados) {
        this.recursosPrestados = recursosPrestados;
    }

    public void agregarRecurso(RecursoDigital recurso) {
        recursosPrestados.add(recurso);
    }

    public void eliminarRecurso(RecursoDigital recurso) {
        recursosPrestados.remove(recurso);
    }
}

package entidades;

import java.util.ArrayList;

public class Usuario {
    private int id;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private String password;
    private ArrayList<RecursoDigital> recursosPrestados = new ArrayList<>();

    public Usuario(int id, String nombre, String apellido, String email, String telefono, String password) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
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

import entidades.Usuario;
import entidades.RecursoDigital;
import excepciones.RecursoMaxRenovacionesExcepcion;
import interfaces.Prestable;
import interfaces.Renovable;
import servicios.GestorUsuarios;
import servicios.GestorRecursos;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Scanner.*;

public class Consola {
    private final GestorUsuarios gestorUsuarios;
    private final GestorRecursos gestorRecursos;
    private ArrayList<RecursoDigital> recursos;
    private Scanner scanner = new Scanner(System.in);
    private Usuario usuario = null;

    public Consola () {
        this.gestorUsuarios = GestorUsuarios.getInstance();
        this.gestorRecursos = GestorRecursos.getInstance();
    }

    public void menuBiblioteca () {
        System.out.println("Bienvenido a la biblioteca digital");
        System.out.println("Por favor, marque que quiere hacer.");
        System.out.println("1. Buscar recurso");
        System.out.println("2. Devoler recurso");
    }

    public void menuBuscarRecurso () {

    }

    public void menuRecurso (RecursoDigital recurso) {
        System.out.println("¿Qué desea hacer con el recurso?");
        System.out.println("1. Prestar el recurso");
        System.out.println("2. Renovar el recurso");
        System.out.println("3. Devolver el recurso");

        int opcion = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer
        switch (opcion) {
            case 1:
                if (recurso instanceof Prestable) {
                    this.prestarRecurso((Prestable) recurso);
                } else {
                    System.out.println("El recurso no es prestable.");
                }
                break;
            case 2:
                if (recurso instanceof Renovable) {
                    this.renovarRecurso((Renovable) recurso);
                } else {
                    System.out.println("El recurso no es prestable.");
                }
                break;
            case 3:
                // Implementar devolución
                break;
            default:
                System.out.println("Opción no válida.");
        }
    }

    public void renovarRecurso(Renovable recurso) {
        System.out.println("¿A qué usuario desea prestarle el recurso?");
        scanner.nextLine();
        String nombreUsuario = scanner.nextLine();

        if (gestorUsuarios.buscarUsuario(nombreUsuario) != null) {
            usuario = gestorUsuarios.buscarUsuario(nombreUsuario);
            if (usuario.getRecursosPrestados().contains(recurso)){
                try {
                    recurso.renovar();
                    System.out.println("Recurso renovado a " + usuario.getNombre());
                } catch (RecursoMaxRenovacionesExcepcion e) {
                    System.out.println(e);
                }
            } else {
                System.out.println("El usuario no tiene este recurso prestado.");
            }
        } else {
            System.out.println("El usuario no existe.");
        }
    }

    public void prestarRecurso (Prestable recurso) {
        System.out.println("¿A qué usuario desea prestarle el recurso?");
        scanner.nextLine();
        String nombreUsuario = scanner.nextLine();

        if (gestorUsuarios.buscarUsuario(nombreUsuario) != null) {
            usuario = gestorUsuarios.buscarUsuario(nombreUsuario);
            if (recurso.estaDisponible()) {
                recurso.prestar();
                System.out.println("Recurso renovado a " + usuario.getNombre());
            } else {
                System.out.println("El recurso no está disponible.");
            }
        } else {
            System.out.println("El usuario no existe.");
        }
    }
}

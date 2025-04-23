import entidades.RecursoPrestable;
import entidades.RecursoRenovable;
import entidades.Usuario;
import entidades.RecursoDigital;
import excepciones.RecursoMaxRenovacionesExcepcion;
import interfaces.Prestable;
import interfaces.Renovable;
import servicios.GestorUsuarios;
import servicios.GestorRecursos;

import java.util.ArrayList;
import java.util.Scanner;

public class Consola {
    private final GestorUsuarios gestorUsuarios;
    private final GestorRecursos gestorRecursos;
    private ArrayList<RecursoDigital> recursos;
    private ArrayList<Usuario> usuarios;
    private Scanner scanner = new Scanner(System.in);

    public Consola () {
        this.gestorUsuarios = GestorUsuarios.getInstance();
        this.gestorRecursos = GestorRecursos.getInstance();
    }

    public void menuBiblioteca () {
        System.out.println("Bienvenido a la biblioteca digital. Por favor, marque que quiere hacer");
        System.out.println("1. Manejar Usuarios");
        System.out.println("1. Manejar Recursos");
    }

    public void menuUsuarios() {
        System.out.println("¿Qué desea hacer con los usuarios?");
        System.out.println("1. Crear usuario");
        System.out.println("2. Buscar usuario");
        System.out.println("3. Eliminar usuario");
        System.out.println("4. Listar usuarios");

        int opcion = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer
        switch (opcion) {
            case 1:
                //this.crearUsuario();
                break;
            case 2:
                //this.buscarUsuario();
                break;
            case 3:
                //this.eliminarUsuario();
                break;
            case 4:
                //this.listarUsuarios();
                break;
            default:
                System.out.println("Opción no válida.");
        }
    }

    public void menuRecursosDigitales () {
        System.out.println("¿Qué desea hacer con los recursos digitales?");
        System.out.println("1. Crear recurso digital");
        System.out.println("2. Buscar recurso digital");
        System.out.println("3. Eliminar recurso digital");
        System.out.println("4. Listar recursos digitales");

        int opcion = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer
        switch (opcion) {
            case 1:
                //this.crearRecursoDigital();
                break;
            case 2:
                //this.buscarRecursoDigital();
                break;
            case 3:
                //this.eliminarRecursoDigital();
                break;
            case 4:
                //this.listarRecursosDigitales();
                break;
            default:
                System.out.println("Opción no válida.");
        }
    }


    public void menuRecursoEspecifico (RecursoDigital recurso) {
        System.out.println("¿Qué desea hacer con el recurso?");
        System.out.println("1. Prestar el recurso");
        System.out.println("2. Renovar el prestamo del recurso");
        System.out.println("3. Marcar la devolucion del recurso");

        int opcion = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer
        switch (opcion) {
            case 1:
                if (recurso instanceof Prestable) {
                    this.prestarRecurso((RecursoPrestable) recurso);
                } else {
                    System.out.println("El recurso no es prestable.");
                }
                break;
            case 2:
                if (recurso instanceof Renovable) {
                    this.renovarRecurso((RecursoRenovable) recurso);
                } else {
                    System.out.println("El recurso no es renovable.");
                }
                break;
            case 3:
                // Implementar devolución
                break;
            default:
                System.out.println("Opción no válida. Vuelta al menú principal.");
                return;
        }
    }

    public void prestarRecurso (RecursoPrestable recurso) {
        if (!recurso.estaDisponible()) {
            System.out.println("El recurso no está disponible para prestamos.");
            return;
        }

        System.out.println("¿A qué usuario desea prestarle el recurso?");
        scanner.nextLine();
        String nombreUsuario = scanner.nextLine();

        if (gestorUsuarios.buscarUsuario(nombreUsuario) != null) {
            Usuario usuario = gestorUsuarios.buscarUsuario(nombreUsuario);
            recurso.prestar(usuario);
            System.out.println("Recurso prestado a " + usuario.getNombre());
        } else {
            System.out.println("El usuario no existe.");
        }
    }

    public void renovarRecurso(RecursoRenovable recurso) {
        if (recurso.estaDisponible()) {
            System.out.println("El recurso no está prestado a ningún usuario.");
            return;
        }

        System.out.println("¿A qué usuario desea prestarle el recurso?");
        scanner.nextLine();
        String nombreUsuario = scanner.nextLine();

        if (gestorUsuarios.buscarUsuario(nombreUsuario) != null) {
            Usuario usuario = gestorUsuarios.buscarUsuario(nombreUsuario);
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
}

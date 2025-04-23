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
        while (true) {
            System.out.println("Bienvenido a la biblioteca digital. Por favor, marque que quiere hacer");
            System.out.println("1. Manejar Usuarios");
            System.out.println("2. Manejar Recursos");
            System.out.println("3. Salir");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer
            switch (opcion) {
                case 1:
                    this.menuUsuarios();
                    break;
                case 2:
                    this.menuRecursosDigitales();
                    break;
                case 3:
                    System.out.println("Saliendo de la biblioteca digital. ¡Hasta luego!");
                    return;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
                    break;
            }
        }
    }

    public void menuUsuarios() {
        while (true) {
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
                    System.out.println("Opción no válida. Vuelta al menú anterior.");
                    return;
            }
        }
    }

    public void menuRecursosDigitales () {
        while (true) {
            System.out.println("¿Qué desea hacer con los recursos digitales?");
            System.out.println("1. Crear recurso digital");
            System.out.println("2. Buscar recurso digital");
            System.out.println("3. Eliminar recurso digital");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer
            switch (opcion) {
                case 1:
                    //this.crearRecursoDigital();
                    break;
                case 2:
                    this.menuBuscarRecurso();
                    break;
                case 3:
                    //this.eliminarRecursoDigital();
                    break;
                default:
                    System.out.println("Opción no válida. Vuelta al menú anterior.");
                    return;
            }
        }
    }

    public void menuBuscarRecurso () {
        while (true) {
            System.out.println("¿Como quiere encontrar el recurso?");
            System.out.println("1. Listar recursos por comandos");
            System.out.println("2. Acceder al recurso por ID o nombre");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer
            switch (opcion) {
                case 1:
                    System.out.println("Buscador:");
                    String comando = scanner.nextLine();
                    ArrayList<RecursoDigital> recursosFiltrados = gestorRecursos.realizarBusquedaPorComandos(comando);
                    if (!recursosFiltrados.isEmpty()) {
                        recursosFiltrados.forEach(RecursoDigital::visualizar);
                    } else {
                        System.out.println("No se encontraron recursos con los parametros usados.");
                    }
                    break;
                case 2:
                    System.out.println("Ingrese el identificador (ID o nombre) del recurso:");
                    String identificador = scanner.nextLine();
                    RecursoDigital recurso = null;

                    recurso = gestorRecursos.buscarPorId(Integer.parseInt(identificador));
                    if (recurso == null) {
                        recurso = gestorRecursos.buscarPorNombre(identificador);
                    }

                    if (recurso != null) {
                        recurso.visualizar();
                        menuRecursoEspecifico(recurso);
                    } else {
                        System.out.println("No se encontró el recurso con el identificador proporcionado.");
                    }
                    break;
                default:
                    System.out.println("Opción no válida. Vuelta al menú anterior.");
                    return;
            }
        }
    }

    public void menuRecursoEspecifico (RecursoDigital recurso) {
        while (true) {
            System.out.println("¿Qué desea hacer con el recurso?");
            System.out.println("0. Ver el recurso");
            System.out.println("1. Prestar el recurso");
            System.out.println("2. Renovar el prestamo del recurso");
            System.out.println("3. Marcar la devolucion del recurso");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer
            switch (opcion) {
                case 0:
                    recurso.visualizar();
                    break;
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
                    System.out.println("Opción no válida. Vuelta al menú anterior.");
                    return;
            }
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

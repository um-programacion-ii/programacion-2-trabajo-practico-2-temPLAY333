import entidades.Usuario;
import entidades.RecursoDigital;
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

    public Consola () {
        this.gestorUsuarios = GestorUsuarios.getInstance();
        this.gestorRecursos = GestorRecursos.getInstance();
    }

    public void menuRecursos(RecursoDigital recurso) {
        System.out.println("1. Crear nuevo " + recurso.tipoRecurso());
        System.out.println("2. Listar " + recurso.tipoRecurso() + "s");
        System.out.println("3. Buscar " + recurso.tipoRecurso());
        System.out.println("0. Volver");

        int opcion = Integer.parseInt(scanner.nextLine());

        switch (opcion) {
            case 1:
                gestorRecursos.createRecurso(recurso);
                break;
            case 2:
                gestorRecursos.listarRecursos();
                break;
            case 3:
                gestorRecursos.buscarRecurso();
                break;
            case 0:
                System.out.println("Volviendo al menú principal...");
                break;
        }
    }
}

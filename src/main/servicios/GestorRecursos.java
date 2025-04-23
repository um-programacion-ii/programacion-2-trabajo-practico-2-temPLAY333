package servicios;

import entidades.RecursoDigital;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

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

    // Metodos de Busqueda para los Recursos Digitales
    public RecursoDigital buscarPorId(int id) {
        return recursosDigitales.stream()
                .filter(recurso -> recurso.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public RecursoDigital buscarPorNombre(String nombre) {
        return recursosDigitales.stream()
                .filter(recurso -> recurso.getNombre().equalsIgnoreCase(nombre))
                .findFirst()
                .orElse(null);
    }

    // Filtrado de Recursos
    public ArrayList<RecursoDigital> realizarBusquedaPorComandos(String consulta) {
        // Comenzar con todos los recursos
        ArrayList<RecursoDigital> resultados = new ArrayList<>(recursosDigitales);

        // Filtrar por autor
        String autor = extraerPatron(consulta, "autor:\"([^\"]*)\"|autor:([^S]+)");
        if (autor != null) {
            resultados = filtrarPorAutor(autor, resultados);
        }

        // Filtrar por categoría
        String categoria = extraerPatron(consulta, "categoria:\"([^\"]*)\"|categoria:([^S]+)");
        if (categoria != null) {
            resultados = filtrarPorCategoria(categoria, resultados);
        }

        // Filtrar por año
        String fechaAno = extraerPatron(consulta, "fecha:(\\d{4})");
        if (fechaAno != null) {
            resultados = filtrarPorAno(Integer.parseInt(fechaAno), resultados);
        }

        // Términos generales (fuera de filtros específicos)
        String terminosGenerales = consulta.replaceAll("\\w+:\"[^\"]*\"|\\w+:[^S]+", "").trim();
        if (!terminosGenerales.isEmpty()) {
            resultados = filtrarPorNombre(terminosGenerales, resultados);
        }

        return resultados;
    }

    public String extraerPatron(String texto, String patron) {
        Pattern pattern = Pattern.compile(patron);
        Matcher matcher = pattern.matcher(texto);
        if (matcher.find()) {
            // Intentar obtener del primer grupo de captura
            String grupo1 = matcher.group(1);
            if (grupo1 != null && !grupo1.isEmpty()) {
                return grupo1;
            }
            // Si hay un segundo grupo, intentar con él
            if (matcher.groupCount() >= 2) {
                return matcher.group(2);
            }
        }
        return null;
    }

    // IA: Queria un sistema de busqueda (filtrado) de palabras parciales en el nombre del recurso
    public ArrayList<RecursoDigital> filtrarPorNombre(String busqueda, ArrayList<RecursoDigital> recursos) {
        return recursos.stream()
                .filter(recurso -> recurso.getNombre().toLowerCase().contains(busqueda.toLowerCase()))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<RecursoDigital> filtrarPorAutor(String autor, ArrayList<RecursoDigital> recursos) {
        return recursos.stream()
                .filter(recurso -> recurso.getAutor().equalsIgnoreCase(autor))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<RecursoDigital> filtrarPorCategoria(String categoria, ArrayList<RecursoDigital> recursos) {
        return recursos.stream()
                .filter(recurso -> recurso.getCategoria().equalsIgnoreCase(categoria))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<RecursoDigital> filtrarPorAno(int ano, ArrayList<RecursoDigital> recursos) {
        return recursos.stream()
                .filter(recurso -> recurso.getFechaPublicacion().getYear() == ano)
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    }

    public ArrayList<RecursoDigital> ordenarPorNombreAscendente() {
        return recursosDigitales.stream()
                .sorted((r1, r2) -> r1.getNombre().compareToIgnoreCase(r2.getNombre()))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<RecursoDigital> ordenarPorNombreDescendente() {
        return recursosDigitales.stream()
                .sorted((r1, r2) -> r2.getNombre().compareToIgnoreCase(r1.getNombre()))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<RecursoDigital> ordenarPorFechaAscendente() {
        return recursosDigitales.stream()
                .sorted(Comparator.comparing(RecursoDigital::getFechaPublicacion))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<RecursoDigital> ordenarPorFechaDescendente() {
        return recursosDigitales.stream()
                .sorted(Comparator.comparing(RecursoDigital::getFechaPublicacion).reversed())
                .collect(Collectors.toCollection(ArrayList::new));
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

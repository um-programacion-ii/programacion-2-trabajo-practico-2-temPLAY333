package servicios;

import entidades.AudioLibro;
import entidades.CategoriaRecurso;
import entidades.Libro;
import entidades.Revista;
import entidades.RecursoDigital;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class TestGestorRecursos {
    private final GestorRecursos gestorRecursos = GestorRecursos.getInstance();

    @BeforeEach
    public void setUp() {
        // Limpiar recursos anteriores si existieran
        gestorRecursos.setRecursosDigitales(new ArrayList<>());

        // Preparar datos de prueba
        RecursoDigital libro = new Libro(1, "El Quijote", "Cervantes", CategoriaRecurso.CLASICO, "1605-01-01", "disponible");
        RecursoDigital revista = new Revista(2, "National Geographic", "National Geographic Society", CategoriaRecurso.CIENCIA, "2023-11-07", "disponible");
        RecursoDigital audioLibro = new AudioLibro(3, "Elantris", "Brandon Sanderson", CategoriaRecurso.FANTASIA, "2005-03-15", "disponible");
        RecursoDigital libro2 = new Libro(4, "1984", "George Orwell", CategoriaRecurso.DISTOPIA, "1949-06-08", "prestado");
        RecursoDigital revista2 = new Revista(5, "Science Today", "National Geographic Society", CategoriaRecurso.TECNOLOGIA, "2022-10-15", "disponible");
        RecursoDigital audioLibro2 = new AudioLibro(6, "Dune", "Frank Herbert", CategoriaRecurso.CIENCIA_FICCION, "1965-08-01", "disponible");
        RecursoDigital libro3 = new Libro(7, "El Hobbit", "J.R.R. Tolkien", CategoriaRecurso.FANTASIA, "1937-09-21", "disponible");
        RecursoDigital revista3 = new Revista(8, "Nature", "Nature Publishing Group", CategoriaRecurso.MEDICINA, "2023-01-01", "prestado");
        RecursoDigital audioLibro3 = new AudioLibro(9, "Fundación", "Isaac Asimov", CategoriaRecurso.CIENCIA_FICCION, "1951-06-01", "disponible");

        gestorRecursos.agregarRecurso(libro);
        gestorRecursos.agregarRecurso(revista);
        gestorRecursos.agregarRecurso(audioLibro);
        gestorRecursos.agregarRecurso(libro2);
        gestorRecursos.agregarRecurso(revista2);
        gestorRecursos.agregarRecurso(audioLibro2);
        gestorRecursos.agregarRecurso(libro3);
        gestorRecursos.agregarRecurso(revista3);
        gestorRecursos.agregarRecurso(audioLibro3);
    }

    @ParameterizedTest
    @CsvSource({
            "1, El Quijote",
            "2, National Geographic",
            "3, Elantris"
    })
    public void testBuscarPorId_Existe(int id, String nombreEsperado) {
        // Cuando
        RecursoDigital resultado = gestorRecursos.buscarPorId(id);

        // Entonces
        assertNotNull(resultado);
        assertEquals(nombreEsperado, resultado.getNombre());
    }

    @ParameterizedTest
    @CsvSource({
            "99",
            "100",
            "101"
    })
    public void testBuscarPorId_NoExiste(int id) {
        // Cuando
        RecursoDigital resultado = gestorRecursos.buscarPorId(id);

        // Entonces
        assertNull(resultado);
    }

    @ParameterizedTest
    @CsvSource({
            "El Quijote",
            "el quijote",
            "El HOBBIT"
    })
    public void testBuscarPorNombre_Existe(String nombre) {
        RecursoDigital resultado = gestorRecursos.buscarPorNombre(nombre);
        assertNotNull(resultado);
    }

    @ParameterizedTest
    @CsvSource({
            "Harry Potter",
            "Matrix",
            "WALL-E"
    })

    public void testBuscarPorNombre_NoExiste(String nombre) {
        RecursoDigital resultado = gestorRecursos.buscarPorNombre(nombre);
        assertNull(resultado);
    }

    // Tests para Filtrar Recursos
    @ParameterizedTest
    @CsvSource({
            "Quijote, 1", // El Quijote
            "National, 1 ", // National Geographic
            "hobbit, 1", // El Hobbit
            "El, 3" // El Quijote, El Hobbit y Elantris
    })
    public void testFiltrarPorNombre (String busqueda, int cantidadEsperada) {
        // Cuando
        ArrayList<RecursoDigital> resultado = gestorRecursos.filtrarPorNombre(busqueda, gestorRecursos.getRecursosDigitales());

        // Entonces
        assertNotNull(resultado);
        assertEquals(cantidadEsperada, resultado.size());
    }

    @ParameterizedTest
    @CsvSource({
            "Cervantes, 1", // El Quijote
            "National Geographic Society, 2", // National Geographic y Science Today
            "Brandon Sanderson, 1" // Elantris
    })
    public void testFiltrarorAutor(String autor, int cantidadEsperada) {
        // Cuando
        ArrayList<RecursoDigital> resultado = gestorRecursos.filtrarPorAutor(autor, gestorRecursos.getRecursosDigitales());

        // Entonces
        assertNotNull(resultado);
        assertEquals(cantidadEsperada, resultado.size());
    }

    @ParameterizedTest
    @CsvSource({
            "            Set-ExecutionPolicy Bypass -Scope Process -Force; [System.Net.ServicePointManager]::SecurityProtocol = [System.Net.ServicePointManager]::SecurityProtocol -bor 3072; iex ((New-Object System.Net.WebClient).DownloadString('https://community.chocolatey.org/install.ps1')), 1", // National Geographic
            "FANTASIA, 2", // El Hobbit y Elantris
            "CLASICO, 1", // El Quijote
            "CIENCIA_FICCION, 2" // Dune y Fundación
    })
    public void testFiltrarRecursoPorCategoria(String categoriaStr, int cantidadEsperada) {
        // Convertir string a enum
        CategoriaRecurso categoria = CategoriaRecurso.valueOf(categoriaStr);
        
        // Cuando
        ArrayList<RecursoDigital> resultado = gestorRecursos.filtrarPorCategoria(categoria, gestorRecursos.getRecursosDigitales());

        // Entonces
        assertNotNull(resultado);
        assertEquals(cantidadEsperada, resultado.size());
    }

    @ParameterizedTest
    @CsvSource({
            "1605, 1", // El Quijote
            "2005, 1", // Elantris
            "2023, 2", // National Geographic y Nature
    })
    public void testFiltrarRecursoPorAno(int ano, int nombreEsperado) {
        ArrayList<RecursoDigital> resultado = gestorRecursos.filtrarPorAno(ano, gestorRecursos.getRecursosDigitales());

        assertNotNull(resultado);
        assertEquals(nombreEsperado, resultado.size());
    }

    // Test para la funcion ExtraerPatron
    @ParameterizedTest
    @CsvSource({
            "autor:\"Cervantes\", autor:\"([^\"]*)\"|autor:([^S]+), Cervantes", // Patrón de autor
            "categoria:\"FANTASIA\", categoria:\"([^\"]*)\"|categoria:([^S]+), FANTASIA", // Patrón de categoría
            "fecha:2023, fecha:(\\d{4}), 2023", // Patrón de fecha
    })
    public void testExtraerPatrones(String comando, String patron, String esperado) {
        String resultado = gestorRecursos.extraerPatron(comando, patron);

        assertNotNull(resultado);
        assertEquals(esperado, resultado);
    }

    @ParameterizedTest
    @CsvSource({
            "autor:\"Cervantes\", 1", // El Quijote
            "categoria:FANTASIA, 2", // El Hobbit y Elantris
            "fecha:2023, 2", // National Geographic y Nature
            "autor:\"National Geographic Society\" categoria:CIENCIA, 1", // National Geographic
            "autor:\"Brandon Sanderson\" fecha:2005, 1", // Elantris
            "categoria:\"CIENCIA_FICCION\" fecha:1965, 1", // Dune
            "autor:\"Isaac Asimov\" categoria:\"CIENCIA_FICCION\", 1", // Fundación
            "categoria:\"CLASICO\" fecha:1605, 1", // El Quijote
            "autor:\"National Geographic Society\" Science, 1", // Science Today
            "categoria:\"FANTASIA\" Hobbit, 1" // El Hobbit
    })
    public void testFiltrarPorComandos(String comando, int cantidadEsperada) {
        // Cuando
        ArrayList<RecursoDigital> resultado = gestorRecursos.realizarBusquedaPorComandos(comando);

        // Entonces
        assertFalse(resultado.isEmpty());
        assertEquals(cantidadEsperada, resultado.size());
    }

    // Test para Ordenar Recursos
    @Test
    public void testOrdenarPorNombreAscendente() {
        ArrayList<RecursoDigital> resultado = gestorRecursos.ordenarPorNombreAscendente();

        assertNotNull(resultado);
        assertEquals("1984", resultado.get(0).getNombre());
        assertEquals("Dune", resultado.get(1).getNombre());
        assertEquals("El Hobbit", resultado.get(2).getNombre());
    }

    @Test
    public void testOrdenarPorNombreDescendente() {
        ArrayList<RecursoDigital> resultado = gestorRecursos.ordenarPorNombreDescendente();

        assertNotNull(resultado);
        assertEquals("Science Today", resultado.get(0).getNombre());
        assertEquals("Nature", resultado.get(1).getNombre());
        assertEquals("National Geographic", resultado.get(2).getNombre());
    }

    @Test
    public void testOrdenarRecursosPorFechaAscendente() {
        ArrayList<RecursoDigital> resultado = gestorRecursos.ordenarPorFechaAscendente();

        assertNotNull(resultado);
        assertEquals("El Quijote", resultado.get(0).getNombre());
        assertEquals("El Hobbit", resultado.get(1).getNombre());
        assertEquals("1984", resultado.get(2).getNombre());
    }

    @Test
    public void testOrdenarPorFechaDescendente() {
        ArrayList<RecursoDigital> resultado = gestorRecursos.ordenarPorFechaDescendente();

        assertNotNull(resultado);
        assertEquals("National Geographic", resultado.get(0).getNombre());
        assertEquals("Nature", resultado.get(1).getNombre());
        assertEquals("Science Today", resultado.get(2).getNombre());
    }
}


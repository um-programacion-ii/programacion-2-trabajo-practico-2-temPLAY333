package servicios;

import entidades.AudioLibro;
import entidades.Libro;
import entidades.Revista;
import entidades.RecursoDigital;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class testGestorRecursos {
    private final GestorRecursos gestorRecursos = GestorRecursos.getInstance();

    @BeforeEach
    public void setUp() {
        // Limpiar recursos anteriores si existieran
        gestorRecursos.setRecursosDigitales(new ArrayList<>());

        // Preparar datos de prueba
        RecursoDigital libro = new Libro(1, "El Quijote", "Clasico", "Cervantes", "1600", "disponible");
        RecursoDigital revista = new Revista(2, "National Geographic", "Ciencia", "National Geographic Society", "2023", "disponible");
        RecursoDigital audioLibro = new AudioLibro(3, "Imperio Final", "Fantasia", "Brandon Sanderson", "2006", "disponible");

        gestorRecursos.agregarRecurso(libro);
        gestorRecursos.agregarRecurso(revista);
        gestorRecursos.agregarRecurso(audioLibro);
    }

    @ParameterizedTest
    @CsvSource({
            "1, El Quijote",
            "2, National Geographic",
            "3, Imperio Final"
    })
    public void testBuscarRecursoPorId_Existe(int id, String nombreEsperado) {
        // Cuando
        RecursoDigital resultado = gestorRecursos.buscarRecursoPorId(id);

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
    public void testBuscarRecursoPorId_NoExiste(int id) {
        // Cuando
        RecursoDigital resultado = gestorRecursos.buscarRecursoPorId(id);

        // Entonces
        assertNull(resultado);
    }

    @ParameterizedTest
    @CsvSource({
            "El Quijote",
            "el quijote",
            "IMPERIO FINAL"
    })
    public void testBuscarRecursoPorNombre_Existe(String nombre) {
        RecursoDigital resultado = gestorRecursos.buscarRecursoPorNombre(nombre);
        assertNotNull(resultado);
    }

    @ParameterizedTest
    @CsvSource({
            "Harry Potter",
            "MAtrix",
            "WALL-E"
    })
    public void testBuscarRecursoPorNombre_NoExiste(String nombre) {
        RecursoDigital resultado = gestorRecursos.buscarRecursoPorNombre(nombre);
        assertNull(resultado);
    }
}
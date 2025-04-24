package servicios;

import entidades.Usuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class TestGestorUsuarios {
    private final GestorUsuarios gestorUsuarios = GestorUsuarios.getInstance();

    @BeforeEach
    public void setUp() {
        // Limpiar usuarios anteriores si existieran
        gestorUsuarios.setUsuarios(new HashMap<>());

        // Preparar datos de prueba
        Usuario estudiante = new Usuario(1, "Juan Pérez", "estudiante", "juan@ejemplo.com");
        Usuario profesor = new Usuario(2, "María López", "profesor", "maria@ejemplo.com");
        Usuario bibliotecario = new Usuario(3, "Juan Carlos Gómez", "bibliotecario", "carlos@ejemplo.com");

        gestorUsuarios.agregarUsuario(estudiante);
        gestorUsuarios.agregarUsuario(profesor);
        gestorUsuarios.agregarUsuario(bibliotecario);
    }

    @ParameterizedTest
    @CsvSource({
            "1, Juan Pérez",
            "2, María López",
            "3, Juan Carlos Gómez"
    })
    public void testBuscarUsuarioPorId_Existe(int id, String nombreEsperado) {
        // Cuando
        Usuario resultado = gestorUsuarios.buscarUsuarioPorId(id);

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
    public void testBuscarUsuarioPorId_NoExiste(int id) {
        // Cuando
        Usuario resultado = gestorUsuarios.buscarUsuarioPorId(id);

        // Entonces
        assertNull(resultado);
    }

    @ParameterizedTest
    @CsvSource({
            "Juan, 2",
            "Ju, 2",
            "María, 1",
            "Carlos, 1",
            "Gómez, 1",
    })
    public void testFiltrarUsuarioPorNombre_Existe(String nombre, int largoEsperado) {
        Map<String, Usuario> usuarios = gestorUsuarios.filtrarPorNombre(nombre);
        assertFalse(usuarios.isEmpty());
        assertEquals(largoEsperado, usuarios.size());
    }

    @ParameterizedTest
    @CsvSource({
            "Juana",
            "Carlos Alberto",
            "Pedro",
            "Luisa"
    })
    public void testFiltrarUsuarioPorNombre_NoExiste(String nombre) {
        Map<String, Usuario> usuarios = gestorUsuarios.filtrarPorNombre(nombre);
        assertTrue(usuarios.isEmpty());
    }
}
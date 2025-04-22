package excepciones;

public class RecursoMaxRenovacionesExcepcion extends RuntimeException {
    public RecursoMaxRenovacionesExcepcion(String message) {
        super("Excedido el número máximo de renovaciones para el recurso " + message);
    }
}
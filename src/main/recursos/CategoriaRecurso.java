package recursos;

/**
 * Enumerado que representa los géneros disponibles para recursos digitales.
 */
public enum CategoriaRecurso {
    CLASICO("Clásico"),
    REALISMO("Realismo"),
    NOVELA("Novela"),
    FANTASIA("Fantasía"),
    CIENCIA_FICCION("Ciencia Ficción"),
    DRAMA("Drama"),
    DOCUMENTAL("Documental"),
    COMEDIA("Comedia"),
    ACCION("Acción"),
    EDUCATIVO("Educativo"),
    OTRO("Otro");

    private final String nombre;

    CategoriaRecurso(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    /**
     * Convierte una cadena de texto a un género.
     * Si no coincide con ningún género, devuelve OTRO.
     */
    public static CategoriaRecurso fromString(String categoria) {
        if (categoria == null || categoria.isEmpty()) {
            return OTRO;
        }
        
        for (CategoriaRecurso cat : CategoriaRecurso.values()) {
            if (cat.getNombre().equalsIgnoreCase(categoria) || 
                cat.name().equalsIgnoreCase(categoria)) {
                return cat;
            }
        }
        return OTRO;
    }
    
    @Override
    public String toString() {
        return nombre;
    }
}

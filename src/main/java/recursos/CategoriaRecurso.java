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
    DISTOPIA("Distopía"),
    CIENCIA("Ciencia"),
    MEDICINA("Medicina"),
    TECNOLOGIA("Tecnología"),
    OTRO("Otro");

    private final String nombre;

    CategoriaRecurso(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    /**
     * Convierte una cadena de texto a una categoría.
     * Si no coincide con ninguna categoría, devuelve OTRO.
     */
    public static CategoriaRecurso fromString(String categoria) {
        if (categoria == null || categoria.trim().isEmpty()) {
            return OTRO;
        }
        
        for (CategoriaRecurso cat : CategoriaRecurso.values()) {
            if (cat.getNombre().equalsIgnoreCase(categoria.trim()) || 
                cat.name().equalsIgnoreCase(categoria.trim())) {
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

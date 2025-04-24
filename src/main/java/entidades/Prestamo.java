package entidades;

import interfaces.ServicioNotificaciones;

public class Prestamo {
    private final ServicioNotificaciones servicioNotificaciones;

    // Inyección por constructor
    public Prestamo(ServicioNotificaciones servicioNotificaciones) {
        this.servicioNotificaciones = servicioNotificaciones;
    }

    public void realizarPrestamo(Usuario usuario, RecursoPrestable recurso) {
        // Lógica de préstamo
        recurso.prestar(usuario);

        // Notificar usando el servicio
        servicioNotificaciones.notificarPrestamoRealizado(usuario, (RecursoDigital)recurso);
    }
}

package entidades;

import interfaces.ServicioNotificaciones;

public class ServicioNotificacionesEmail implements ServicioNotificaciones {
    public void notificarPrestamoRealizado(Usuario usuario, RecursoDigital recurso) {
        System.out.println("Enviando notificación por email a " + usuario.getNombre() + ": El prestamo para el recurso " + recurso.getNombre() + " ha sido realizado con éxito.");
    }

    public void notificarVencimientoProximo(Usuario usuario, RecursoDigital recurso, int diasRestantes) {
        System.out.println("Enviando notificación por email a " + usuario.getNombre() + ": El recurso " + recurso.getNombre() + " vencerá en " + diasRestantes + " días.");
    }

    public void notificarPrestamoVencido(Usuario usuario, RecursoDigital recurso, int diasVencido) {
        System.out.println("Enviando notificación por email a " + usuario.getNombre() + ": El recurso " + recurso.getNombre() + " ha vencido hace " + diasVencido + " días.");
    }

    public void notificarRecursoDisponible(Usuario usuario, RecursoDigital recurso) {
        System.out.println("Enviando notificación por email a " + usuario.getNombre() + ": El recurso " + recurso.getNombre() + " ya está disponible.");
    }
}
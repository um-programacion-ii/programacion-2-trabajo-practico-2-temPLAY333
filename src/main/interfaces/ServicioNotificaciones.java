package interfaces;

import entidades.RecursoDigital;
import entidades.Usuario;

public interface ServicioNotificaciones {
    void notificarPrestamoRealizado(Usuario usuario, RecursoDigital recurso);
    void notificarVencimientoProximo(Usuario usuario, RecursoDigital recurso, int diasRestantes);
    void notificarPrestamoVencido(Usuario usuario, RecursoDigital recurso, int diasVencido);
    void notificarRecursoDisponible(Usuario usuario, RecursoDigital recurso);
}

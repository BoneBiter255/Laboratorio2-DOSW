package edu.dosw.lab.Laboratorio_2_CVDS_DOSW_01.Comportamiento.reto6;

class TecnicoIntermedio extends Tecnico {
    public TecnicoIntermedio() { this.nombre = "Técnico Intermedio"; }

    @Override
    public boolean procesarTicket(Ticket ticket, StringBuilder log) {
        if (ticket.getNivel() == Ticket.Nivel.INTERMEDIO && ticket.getPrioridad() != Ticket.Prioridad.ALTA) {
            log.append(nombre).append(" resolvió el problema.");
            ticketsResueltos++;
            return true;
        } else {
            log.append(nombre).append(" no pudo resolver. ");
            return pasarAlSiguiente(ticket, log);
        }
    }
}
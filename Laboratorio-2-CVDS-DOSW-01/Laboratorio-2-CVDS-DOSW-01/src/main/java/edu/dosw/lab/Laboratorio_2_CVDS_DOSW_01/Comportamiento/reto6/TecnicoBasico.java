package edu.dosw.lab.Laboratorio_2_CVDS_DOSW_01.Comportamiento.reto6;

class TecnicoBasico extends Tecnico {
    public TecnicoBasico() { this.nombre = "Técnico Básico"; }

    @Override
    public boolean procesarTicket(Ticket ticket, StringBuilder log) {
        if (ticket.getNivel() == Ticket.Nivel.BASICO && ticket.getPrioridad() != Ticket.Prioridad.ALTA) {
            log.append(nombre).append(" resolvió el problema.");
            ticketsResueltos++;
            return true;
        } else {
            log.append(nombre).append(" no pudo resolver. ");
            return pasarAlSiguiente(ticket, log);
        }
    }
}
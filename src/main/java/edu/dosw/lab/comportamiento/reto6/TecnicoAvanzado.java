package edu.dosw.lab.comportamiento.reto6;

class TecnicoAvanzado extends Tecnico {
    public TecnicoAvanzado() { this.nombre = "Técnico Avanzado"; }

    @Override
    public boolean procesarTicket(Ticket ticket, StringBuilder log) {
        if (ticket.getNivel() == Ticket.Nivel.AVANZADO ||
            (ticket.getNivel() == Ticket.Nivel.INTERMEDIO && ticket.getPrioridad() == Ticket.Prioridad.ALTA)) {
            log.append(nombre).append(" resolvió el problema.");
            ticketsResueltos++;
            return true;
        } else {
            log.append(nombre).append(" no pudo resolver. ");
            return pasarAlSiguiente(ticket, log);
        }
    }
}
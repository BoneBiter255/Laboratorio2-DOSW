package edu.dosw.lab.Laboratorio_2_CVDS_DOSW_01.Comportamiento.reto6;

public abstract class Tecnico implements Handler {
    public int getTicketsResueltos() {
        return ticketsResueltos;
    }
    protected Handler next;
    protected String nombre;
    protected int ticketsResueltos = 0;

    @Override
    public void setNext(Handler next) {
        this.next = next;
    }

    protected boolean pasarAlSiguiente(Ticket ticket, StringBuilder log) {
        if (next != null) {
            return next.procesarTicket(ticket, log);
        } else {
            log.append("Ningún técnico disponible. Ticket pendiente de escalamiento");
            return false;
        }
    }
}

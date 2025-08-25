package edu.dosw.lab.comportamiento.reto6;

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

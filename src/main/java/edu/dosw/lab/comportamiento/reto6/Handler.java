package edu.dosw.lab.comportamiento.reto6;

public interface Handler {
    void setNext(Handler handler);
    boolean procesarTicket(Ticket ticket, StringBuilder log);
}


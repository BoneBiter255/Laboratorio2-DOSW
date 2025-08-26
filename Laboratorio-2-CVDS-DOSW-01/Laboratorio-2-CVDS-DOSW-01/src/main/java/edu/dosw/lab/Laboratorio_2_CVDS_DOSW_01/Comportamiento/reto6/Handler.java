package edu.dosw.lab.Laboratorio_2_CVDS_DOSW_01.Comportamiento.reto6;

public interface Handler {
    void setNext(Handler handler);
    boolean procesarTicket(Ticket ticket, StringBuilder log);
}


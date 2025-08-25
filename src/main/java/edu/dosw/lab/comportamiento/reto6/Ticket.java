package edu.dosw.lab.comportamiento.reto6;

public class Ticket {
    public enum Nivel { BASICO, INTERMEDIO, AVANZADO }
    public enum Prioridad { BAJA, MEDIA, ALTA }

    private Nivel nivel;
    private Prioridad prioridad;
    private String descripcion;

    public Ticket(Nivel nivel, Prioridad prioridad, String descripcion) {
        this.nivel = nivel;
        this.prioridad = prioridad;
        this.descripcion = descripcion;
    }

    public Nivel getNivel() { return nivel; }
    public Prioridad getPrioridad() { return prioridad; }
    public String getDescripcion() { return descripcion; }

    @Override
    public String toString() {
        return "Ticket{" +
                "nivel=" + nivel +
                ", prioridad=" + prioridad +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}

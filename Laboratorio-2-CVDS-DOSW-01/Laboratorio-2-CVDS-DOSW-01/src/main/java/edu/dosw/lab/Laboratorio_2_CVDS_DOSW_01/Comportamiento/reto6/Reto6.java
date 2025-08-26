package edu.dosw.lab.Laboratorio_2_CVDS_DOSW_01.Comportamiento.reto6;

import java.util.*;

public class Reto6 {
    public static void ejecutar() {
        System.out.println("\n--- Ejecutando Reto 6: Soporte Técnico ---");
        Scanner sc = new Scanner(System.in);

        TecnicoBasico basico = new TecnicoBasico();
        TecnicoIntermedio intermedio = new TecnicoIntermedio();
        TecnicoAvanzado avanzado = new TecnicoAvanzado();
        basico.setNext(intermedio);
        intermedio.setNext(avanzado);

        System.out.print("Ingrese el número de tickets: ");
        int n = Integer.parseInt(sc.nextLine());
        List<Ticket> tickets = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            System.out.println("\n--- Ticket " + i + " ---");

            System.out.print("Nivel (BASICO, INTERMEDIO, AVANZADO): ");
            Ticket.Nivel nivel = Ticket.Nivel.valueOf(sc.nextLine().trim().toUpperCase());

            System.out.print("Prioridad (BAJA, MEDIA, ALTA): ");
            Ticket.Prioridad prioridad = Ticket.Prioridad.valueOf(sc.nextLine().trim().toUpperCase());

            System.out.print("Descripción: ");
            String descripcion = sc.nextLine();

            tickets.add(new Ticket(nivel, prioridad, descripcion));
        }

        int index = 1;
        int pendientes = 0;
        for (Ticket t : tickets) {
            StringBuilder log = new StringBuilder();
            log.append("Ticket ").append(index).append(": ");
            boolean resuelto = basico.procesarTicket(t, log);
            if (!resuelto && log.toString().contains("pendiente de escalamiento")) {
                pendientes++;
            }
            System.out.println(log.toString() + "\n");
            index++;
        }

        System.out.println("-- Estadísticas ---");
        System.out.println("Tickets resueltos:");
        int totalResueltos = basico.getTicketsResueltos() + intermedio.getTicketsResueltos() + avanzado.getTicketsResueltos();
        System.out.println("Básico: " + basico.getTicketsResueltos());
        System.out.println("Intermedio: " + intermedio.getTicketsResueltos());
        System.out.println("Avanzado: " + avanzado.getTicketsResueltos());
        System.out.println("Pendientes de escalamiento: " + pendientes);

        int sumaPrioridades = 0;
        int ticketsResueltos = 0;
        index = 1;
        for (Ticket t : tickets) {
            StringBuilder log = new StringBuilder();
            log.append("Ticket ").append(index).append(": ");
            boolean resuelto = basico.procesarTicket(t, log);
            if (resuelto) {
                int valorPrioridad = 0;
                switch (t.getPrioridad()) {
                    case BAJA:
                        valorPrioridad = 1;
                        break;
                    case MEDIA:
                        valorPrioridad = 2;
                        break;
                    case ALTA:
                        valorPrioridad = 3;
                        break;
                }
                sumaPrioridades += valorPrioridad;
                ticketsResueltos++;
            }
            index++;
        }
        double promedioPrioridad = ticketsResueltos > 0 ? (double) sumaPrioridades / ticketsResueltos : 0;
        System.out.printf("Promedio de prioridad de tickets resueltos: %.2f\n", promedioPrioridad);
    }
}

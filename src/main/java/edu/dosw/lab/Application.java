package edu.dosw.lab;

public class Application {
    public static void main(String[] args) {
        System.out.println("Proyecto Maven configurado correctamente. ");
        java.util.Scanner sc = new java.util.Scanner(System.in);
        while (true) {
            System.out.println("\n¿Qué reto quieres ejecutar?");
            System.out.println("6. Reto 6 - Habla con Soporte Técnico");
            System.out.println("7. Reto 7 - EL Control Remoto Mágico");
            System.out.println("9. Salir");
            System.out.print("Selecciona una opción: ");
            String opcion = sc.nextLine();
            if (opcion.equals("6")) {
                retoHablaConSoporteTecnico();
            } else if (opcion.equals("7")) {
                retoControlRemoto();
            } else if (opcion.equals("9")) {
                System.out.println("¡Hasta luego!");
                break;
            } else {
                System.out.println("Opción no válida. Intenta de nuevo.");
            }
        }
    }

    // Reto 6
    public static void retoHablaConSoporteTecnico() {
    edu.dosw.lab.comportamiento.reto6.Reto6.ejecutar();
    }

    // Reto 7
    public static void retoControlRemoto() {
        edu.dosw.lab.comportamiento.reto7.Reto7.main(new String[]{});
    }
}

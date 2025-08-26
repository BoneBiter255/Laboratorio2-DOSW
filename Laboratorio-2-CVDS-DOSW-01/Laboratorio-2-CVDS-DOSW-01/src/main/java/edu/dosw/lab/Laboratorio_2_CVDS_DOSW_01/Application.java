package edu.dosw.lab.Laboratorio_2_CVDS_DOSW_01;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        do {
            System.out.println("\nProyecto Maven configurado y corriendo correctamente.");
            System.out.println("Seleccione el reto a ejecutar:");
            System.out.println("1. Reto 1");
            System.out.println("2. Reto 2");
            System.out.println("3. Reto 3");
            System.out.println("4. Reto 4");
            System.out.println("5. Reto 5");
            System.out.println("6. Reto 6");
            System.out.println("7. Reto 7");
            System.out.println("0. Salir");
            System.out.print("Ingrese una opción: ");
            try {
                opcion = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                opcion = -1;
            }
            switch (opcion) {
                case 1:
                    ejecutarReto1();
                    break;
                case 2:
                    ejecutarReto2();
                    break;
                case 3:
                    ejecutarReto3();
                    break;
                case 4:
                    ejecutarReto4();
                    break;
                case 5:
                    ejecutarReto5();
                    break;
                case 6:
                    ejecutarReto6();
                    break;
                case 7:
                    ejecutarReto7();
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 0);
        sc.close();
    }

    // Métodos para ejecutar los retos 1 al 7
    public static void ejecutarReto1() {
        edu.dosw.lab.Laboratorio_2_CVDS_DOSW_01.Comportamiento.Reto1.TiendaDonPepe.main(new String[]{});
    }
    public static void ejecutarReto2() {
        edu.dosw.lab.Laboratorio_2_CVDS_DOSW_01.Creacionales.Reto2.ChefBurgerApp.main(new String[]{});
    }
    public static void ejecutarReto3() {
        edu.dosw.lab.Laboratorio_2_CVDS_DOSW_01.Creacionales.Reto3.ReinoVehiculos.main(new String[]{});
    }
    public static void ejecutarReto4() {
        edu.dosw.lab.Laboratorio_2_CVDS_DOSW_01.Comportamiento.Reto4.CasaDeCambio.main(new String[]{});
    }
    public static void ejecutarReto5() {
        edu.dosw.lab.Laboratorio_2_CVDS_DOSW_01.Estructurales.Reto5.CafePersonalizadoApp.main(new String[]{});
    }
    public static void ejecutarReto6() {
        edu.dosw.lab.Laboratorio_2_CVDS_DOSW_01.Comportamiento.reto6.Reto6.ejecutar();
    }
    public static void ejecutarReto7() {
        edu.dosw.lab.Laboratorio_2_CVDS_DOSW_01.Comportamiento.reto7.Reto7.main(new String[]{});
    }
}
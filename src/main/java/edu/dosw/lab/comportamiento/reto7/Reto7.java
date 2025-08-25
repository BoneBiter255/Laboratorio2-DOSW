package edu.dosw.lab.comportamiento.reto7;
import java.util.*;

public class Reto7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Dispositivos disp = new Dispositivos();
        ControlRemoto control = new ControlRemoto();
        
        System.out.print("Número de acciones a registrar: ");
        int n = sc.nextInt(); sc.nextLine();
        
        for (int i = 1; i <= n; i++) {
            System.out.println("\nAcción " + i + ":");
            System.out.print("Usuario: ");
            String usuario = sc.nextLine();
            System.out.println("Seleccione: 1. Encender luz  2. Abrir puerta  3. Reproducir música  4. Ajustar volumen");
            int opcion = sc.nextInt(); sc.nextLine();
            
            Comando comando = null;
            if (opcion == 1) comando = new EncenderLuz(disp, usuario);
            else if (opcion == 2) comando = new AbrirPuerta(disp, usuario);
            else if (opcion == 3) comando = new ReproducirMusica(disp, usuario);
            else if (opcion == 4) {
                AjustarVolumen av = new AjustarVolumen(disp, usuario);
                System.out.print("Ingrese valor (0-100): ");
                int val = sc.nextInt(); sc.nextLine();
                av.setValor(val);
                comando = (Comando) av;
            }
            
            if (comando != null) {
                control.ejecutarComando(comando);
                System.out.print("¿Deshacer acción? (si/no): ");
                String resp = sc.nextLine();
                if (resp.equalsIgnoreCase("si")) {
                    control.deshacerUltimo();
                }
            }
        }
        
        control.mostrarHistorial();
        control.resumenPorUsuario();
    }
}

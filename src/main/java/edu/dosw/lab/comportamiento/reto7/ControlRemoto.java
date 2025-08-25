package edu.dosw.lab.comportamiento.reto7;
import java.util.*;

public class ControlRemoto {
    private List<Comando> historial = new ArrayList<>();
    private List<String> historialMensajes = new ArrayList<>();

    public void ejecutarComando(Comando comando) {
        comando.ejecutar();
        historial.add(comando);
        historialMensajes.add("Acción ejecutada por " + comando.getUsuario() + ": " + comando.descripcion());
    }

    public void deshacerUltimo() {
        if (!historial.isEmpty()) {
            Comando c = historial.get(historial.size() - 1);
            c.deshacer();
            String mensajeOriginal = "Acción ejecutada por " + c.getUsuario() + ": " + c.descripcion();
            for (int i = historialMensajes.size() - 1; i >= 0; i--) {
                if (historialMensajes.get(i).equals(mensajeOriginal)) {
                    historialMensajes.set(i, mensajeOriginal + " (deshecha)");
                    break;
                }
            }
            historial.remove(historial.size() - 1);
        } else {
            System.out.println("No hay comandos para deshacer.");
        }
    }

    public void mostrarHistorial() {
        System.out.println("\n--- Historial de comandos: ---");
        int i = 1;
        for (String msg : historialMensajes) {
            System.out.println("Acción " + i + ": " + msg);
            i++;
        }
    }

    public void resumenPorUsuario() {
        System.out.println("\n--- Investigando quién desconfiguró los electrodomésticos: : ---");
        Map<String, Integer> alteradores = new LinkedHashMap<>();
        Map<String, Integer> normales = new LinkedHashMap<>();
        for (String msg : historialMensajes) {
            if (msg.startsWith("Acción ejecutada por ")) {
                String usuario = extraerUsuario(msg);
                if (msg.endsWith("(deshecha)")) {
                    alteradores.put(usuario, alteradores.getOrDefault(usuario, 0) + 1);
                } else {
                    normales.put(usuario, normales.getOrDefault(usuario, 0) + 1);
                }
            }
        }
        if (alteradores.isEmpty()) {
            System.out.println("No se detectaron acciones que alteraran la configuración.");
        } else {
            for (String usuario : alteradores.keySet()) {
                System.out.println("Se detecta que " + usuario + " realizó " + alteradores.get(usuario) + " acciones que alteraron la configuración.");
            }
        }
        for (String usuario : normales.keySet()) {
            int cantidad = normales.get(usuario);
            String texto = cantidad == 1 ? "acción" : "acciones";
            System.out.println(usuario + " realizó " + cantidad + " " + texto + ".");
        }
    }

    private String extraerUsuario(String msg) {
        try {
            int ini = msg.indexOf("por ") + 4;
            int fin = msg.indexOf(":", ini);
            return msg.substring(ini, fin).trim();
        } catch (Exception e) {
            return "Desconocido";
        }
    }
    
}

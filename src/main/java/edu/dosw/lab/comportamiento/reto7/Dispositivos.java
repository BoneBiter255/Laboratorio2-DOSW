package edu.dosw.lab.comportamiento.reto7;

public class Dispositivos {
    public void encenderLuz() {
        System.out.println("Luz encendida");
    }

    public void apagarLuz() {
        System.out.println("Luz apagada");
    }

    public void abrirPuerta() {
        System.out.println("Puerta abierta");
    }

    public void cerrarPuerta() {
        System.out.println("Puerta cerrada");
    }

    public void reproducirMusica() {
        System.out.println("Música reproducida");
    }

    public void detenerMusica() {
        System.out.println("Música detenida");
    }

    public void ajustarVolumen(int nivel) {
        System.out.println("Volumen ajustado a: " + nivel + "%");
    }

    public void volumenCero() {
        System.out.println("Volumen en 0%");
    }
}

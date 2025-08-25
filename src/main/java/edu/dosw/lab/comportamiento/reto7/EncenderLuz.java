package edu.dosw.lab.comportamiento.reto7;

public class EncenderLuz implements Comando {
    private Dispositivos disp;
    private String usuario;
    public EncenderLuz(Dispositivos disp, String usuario) {
        this.disp = disp;
        this.usuario = usuario;
    }

    public void ejecutar() {
        System.out.println("Acción ejecutada por:" + usuario);
        disp.encenderLuz();
    }

    public void deshacer() {
        System.out.println("Acción deshecha por: Luz apagada");
        disp.apagarLuz();
    }

    public String descripcion() {
        return "Encender luz - Usuario: " + usuario;
    }

    public String getUsuario() {
        return usuario;
    }
}
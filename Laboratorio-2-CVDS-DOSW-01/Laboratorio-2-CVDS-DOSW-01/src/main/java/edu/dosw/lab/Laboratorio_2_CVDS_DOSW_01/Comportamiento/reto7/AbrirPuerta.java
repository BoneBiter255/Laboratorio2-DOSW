package edu.dosw.lab.Laboratorio_2_CVDS_DOSW_01.Comportamiento.reto7;

public class AbrirPuerta implements Comando {
    private Dispositivos disp;
    private String usuario;
    public AbrirPuerta(Dispositivos disp, String usuario) {
        this.disp = disp;
        this.usuario = usuario;
    }
    public void ejecutar() {
        System.out.println("Acción ejecutada por:" + usuario);
        disp.abrirPuerta();
    }

    public void deshacer() {
        System.out.println("Acción deshecha por: Puerta cerrada");
        disp.cerrarPuerta();
    }

    public String descripcion() {
        return "Abrir puerta - Usuario: " + usuario;
    }

    public String getUsuario() {
        return usuario;
    }
}

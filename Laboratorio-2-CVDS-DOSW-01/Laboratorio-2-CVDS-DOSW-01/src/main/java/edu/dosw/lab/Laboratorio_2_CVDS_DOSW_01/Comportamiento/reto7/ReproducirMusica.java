package edu.dosw.lab.Laboratorio_2_CVDS_DOSW_01.Comportamiento.reto7;

public class ReproducirMusica implements Comando {
    private Dispositivos disp;
    private String usuario;
    public ReproducirMusica(Dispositivos disp, String usuario) {
        this.disp = disp;
        this.usuario = usuario;
    }

    public void ejecutar() {
        System.out.println("Acción ejecutada por: " + usuario);
        disp.reproducirMusica();
    }

    public void deshacer() {
        System.out.println("Acción deshecha por: Música detenida");
        disp.detenerMusica();
    }

    public String descripcion() {
        return "Reproducir música - Usuario: " + usuario;
    }

    public String getUsuario() {
        return usuario;
    }
}

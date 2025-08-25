package edu.dosw.lab.comportamiento.reto7;

public class AjustarVolumen implements Comando {
    private Dispositivos disp;
    private String usuario;
    private int nivel;
    public AjustarVolumen(Dispositivos disp, String usuario) {
        this.disp = disp;
        this.usuario = usuario;
    }

    public void setValor(int valor) {
        this.nivel = valor;
    }

    public void ejecutar() {
        System.out.println("Acción ejecutada por: " + usuario + ":");
        disp.ajustarVolumen(nivel);
    }

    public void deshacer() {
        System.out.println("Acción deshecha por: " + usuario + ":");
        disp.volumenCero();
    }

    public String descripcion() {
        return "Ajustar volumen a " + nivel + "% - Usuario: " + usuario;
    }

    public String getUsuario() {
        return usuario;
    }
}
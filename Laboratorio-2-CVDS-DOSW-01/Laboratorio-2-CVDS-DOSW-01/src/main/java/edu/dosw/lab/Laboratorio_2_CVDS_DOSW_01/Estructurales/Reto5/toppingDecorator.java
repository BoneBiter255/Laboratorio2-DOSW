package edu.dosw.lab.Laboratorio_2_CVDS_DOSW_01.Estructurales.Reto5;
abstract class ToppingDecorator implements Cafe {
    protected Cafe cafe;

    public ToppingDecorator(Cafe cafe) {
        this.cafe = cafe;
    }
}
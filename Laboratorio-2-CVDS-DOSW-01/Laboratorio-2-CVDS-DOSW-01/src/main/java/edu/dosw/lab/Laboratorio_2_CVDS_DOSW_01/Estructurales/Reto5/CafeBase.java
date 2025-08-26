package edu.dosw.lab.Laboratorio_2_CVDS_DOSW_01.Estructurales.Reto5;

public class CafeBase implements Cafe {
    @Override
    public String getDescripcion() {
        return "Café base";
    }

    @Override
    public double getPrecio() {
        return 3000; // precio base fijo
    }
}



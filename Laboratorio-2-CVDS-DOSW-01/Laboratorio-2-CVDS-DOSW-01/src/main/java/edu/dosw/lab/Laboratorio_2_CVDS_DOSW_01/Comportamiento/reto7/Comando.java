package edu.dosw.lab.Laboratorio_2_CVDS_DOSW_01.Comportamiento.reto7;
import java.util.*;

public interface Comando {
    void ejecutar();
    void deshacer();
    String descripcion();
    String getUsuario();
}
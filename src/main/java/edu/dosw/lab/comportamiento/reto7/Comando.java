package edu.dosw.lab.comportamiento.reto7;
import java.util.*;

public interface Comando {
    void ejecutar();
    void deshacer();
    String descripcion();
    String getUsuario();
}
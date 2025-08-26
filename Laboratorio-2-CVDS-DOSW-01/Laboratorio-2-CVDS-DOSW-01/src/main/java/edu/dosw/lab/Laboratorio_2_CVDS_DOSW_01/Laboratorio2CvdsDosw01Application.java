package edu.dosw.lab.Laboratorio_2_CVDS_DOSW_01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import edu.dosw.lab.Laboratorio_2_CVDS_DOSW_01.Comportamiento.reto6.Reto6;

@SpringBootApplication
public class Laboratorio2CvdsDosw01Application {

	public static void main(String[] args) {
		SpringApplication.run(Laboratorio2CvdsDosw01Application.class, args);
	}

	// Reto 6
	public static void ejecutarReto6() {
		Reto6.ejecutar();
	}

}

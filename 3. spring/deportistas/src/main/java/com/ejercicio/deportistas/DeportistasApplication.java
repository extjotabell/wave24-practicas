package com.ejercicio.deportistas;

import com.ejercicio.deportistas.classes.Person;
import com.ejercicio.deportistas.classes.Sport;
import com.ejercicio.deportistas.controllers.DeporteController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DeportistasApplication {

	public static void main(String[] args) {
		SpringApplication.run(DeportistasApplication.class, args);

		DeporteController sportsController = new DeporteController();

		Person person1 = new Person("Diego","Pachon","23", "Tenis");

		DeporteController.addPerson(person1);

		Sport sport1 = new Sport("Futbol", "Intermedio");
		Sport sport2 = new Sport("VoleyBall", "Avanzado");

		DeporteController.addSport(sport1);
		DeporteController.addSport(sport2);


	}
}
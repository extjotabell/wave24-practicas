package com.Sports.sport;

import com.Sports.sport.Controllers.SportController;
import org.springframework.aop.support.DelegatePerTargetObjectIntroductionInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SportApplication {

	public static void main(String[] args) {
		SpringApplication.run(SportApplication.class, args);

		SportController sportsController = new SportController();

		Person person1 = new Person("Diego","Pachon","23", "Tenis");

		SportController.addPerson(person1);

		Sport futbol = new Sport("Futbol", "Intermedio");

		SportController.addSport(futbol);


	}
}

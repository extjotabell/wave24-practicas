package com.spring.responseuno.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		Deporte d1 = new Deporte("futbol",2);
		Deporte d2 = new Deporte("basquet",3);
		Deporte d3 = new Deporte("natacion",1);


		Sistema.listSport.add(d1);
		Sistema.listSport.add(d2);
		Sistema.listSport.add(d3);

		SpringApplication.run(DemoApplication.class, args);
	}

}

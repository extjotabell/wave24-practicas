package com.bootcamp.MiniSeries;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
* En application.properties se configuraron los parametros tal como decia en PG para usar h2.
* Se levantó en http://localhost:8080/h2-console
*
* */
@SpringBootApplication
public class MiniSeriesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MiniSeriesApplication.class, args);
	}

}


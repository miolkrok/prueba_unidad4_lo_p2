package com.uce.edu.demo;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class PruebaUnidad4LoP2Application {

	private static Logger LOG = Logger.getLogger(PruebaUnidad4LoP2Application.class);
	
	public static void main(String[] args) {
		SpringApplication.run(PruebaUnidad4LoP2Application.class, args);
		LOG.info("log");
	}

}

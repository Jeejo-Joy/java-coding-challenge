package com.crewmeister.cmcodingchallenge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.crewmeister.cmcodingchallenge.loader.CurrencyLoader;

@SpringBootApplication
public class CmCodingChallengeApplication {

	public static void main(String[] args) {
		SpringApplication.run(CmCodingChallengeApplication.class, args);
		
		System.out.println("Loading the XMl for parsing.");
		
		CurrencyLoader.load("classpath:eurofxref-hist-90d.xml");
//		CurrencyLoader.load("classpath:employee.xml"); // sample payload
		
		CurrencyLoader.createDS();
//		CurrencyLoader.print(); // to print the loaded data
		System.out.println("XML Parsing is complete");
		
	}

}

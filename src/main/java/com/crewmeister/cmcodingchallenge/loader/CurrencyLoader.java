package com.crewmeister.cmcodingchallenge.loader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.springframework.util.ResourceUtils;

public class CurrencyLoader {

	static Envelope env = null;

	static Map<String, List<Cube>> data = new HashMap<>();

	public static Envelope load(String name) {

		JAXBContext jaxbContext;
		try {
			File xmlFile = ResourceUtils.getFile(name);
			jaxbContext = JAXBContext.newInstance(Envelope.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

			env = (Envelope) jaxbUnmarshaller.unmarshal(xmlFile);

			return env;

		} catch (JAXBException | FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void print() {

		System.out.println(env);
		Cubes c12 = env.getCubes();

		System.out.println(env.getSubject());

		for (Cubet iterable_element : c12.getCubet()) {

			System.out.print(iterable_element.getTime());
			System.out.print(iterable_element.getCube().size());
			System.out.println();

		}
	}

	private static Set<String> currencies = new HashSet<>();

	private static Map<String, List<Cube>> exchangeDataByDates = new HashMap<>();

	public static List<String> getCurrencies() {
		
        List<String> list = new ArrayList<>(currencies);
        Collections.sort(list);
		return list;
	}

	public static List<Cube> getExchangeRatesByDate(String pDate) {
		return exchangeDataByDates.get(pDate);
	}

	public static Map<String, List<Cube>> getExchangeAllRates() {
		return exchangeDataByDates;
	}
	
	public static List<Cube> getTodayExchangeRate() {
		return exchangeDataByDates.get("2022-09-16");
	}

	public static void createDS() {

		Cubes c12 = env.getCubes();

		for (Cubet iterable_element : c12.getCubet()) {
			exchangeDataByDates.put(iterable_element.getTime(), iterable_element.getCube());
		}

		for (Cubet iterable_element : c12.getCubet()) {
			for (Cube iterable_element1 : iterable_element.getCube()) {
				currencies.add(iterable_element1.getCurrency());
			}
			break;
		}

	}

}

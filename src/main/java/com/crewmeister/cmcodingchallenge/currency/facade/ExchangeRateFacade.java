package com.crewmeister.cmcodingchallenge.currency.facade;

import java.util.List;
import java.util.Map;

import com.crewmeister.cmcodingchallenge.loader.Cube;

public interface ExchangeRateFacade {

	List<String> getCurrencies();

	Map<String, List<Cube>> getAllExchangeRates();

	List<Cube> getAllExchangeRateByDate(String date);

	double getCurrencyInEUR(String currency);

	double getCurrencyInEUR(String currency, String date);

	List<Cube> getTodayExchangeRate();

}

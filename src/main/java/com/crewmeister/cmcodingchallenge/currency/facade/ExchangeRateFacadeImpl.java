package com.crewmeister.cmcodingchallenge.currency.facade;

import java.util.List;
import java.util.Map;

import com.crewmeister.cmcodingchallenge.loader.Cube;
import com.crewmeister.cmcodingchallenge.loader.CurrencyLoader;

public class ExchangeRateFacadeImpl implements ExchangeRateFacade {

	@Override
	public List<String> getCurrencies() {
		return CurrencyLoader.getCurrencies();
	}

	@Override
	public Map<String, List<Cube>> getAllExchangeRates() {
		return CurrencyLoader.getExchangeAllRates();
	}

	@Override
	public List<Cube> getAllExchangeRateByDate(String date) {
		return CurrencyLoader.getExchangeAllRates().get(date);
	}

	@Override
	public double getCurrencyInEUR(String currency) {
		List<Cube> rates = this.getTodayExchangeRate();
		return getRate(currency, rates);
	}

	@Override
	public double getCurrencyInEUR(String currency, String date) {
		List<Cube> rates = CurrencyLoader.getExchangeRatesByDate(date);
		return getRate(currency, rates);
	}

	@Override
	public List<Cube> getTodayExchangeRate() {
		return CurrencyLoader.getTodayExchangeRate();
	}

	private double getRate(String currency, List<Cube> rates) {
		if (rates == null)
			return 0;

		for (Cube cube : rates) {
			if (cube.getCurrency().equalsIgnoreCase(currency)) {
				return cube.getRate();
			}
		}
		return 0;
	}
}

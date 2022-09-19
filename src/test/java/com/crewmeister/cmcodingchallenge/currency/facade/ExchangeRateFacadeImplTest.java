package com.crewmeister.cmcodingchallenge.currency.facade;

//import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import com.crewmeister.cmcodingchallenge.loader.Cube;
import com.crewmeister.cmcodingchallenge.loader.CurrencyLoader;

class ExchangeRateFacadeImplTest {

	private ExchangeRateFacade erf = new ExchangeRateFacadeImpl();

	@BeforeEach
	public void name() {
		CurrencyLoader.load("classpath:eurofxref-hist-90d.xml");
		CurrencyLoader.createDS();
	}

	@Test
	void test_getCurrencies() {
		List<String> cur = erf.getCurrencies();

		Assert.notNull(cur, "currency is loaded");

	}

	@Test
	void test_getAllExchangeRates() {
		Map<String, List<Cube>> cur = erf.getAllExchangeRates();

		Assert.notNull(cur, "rates is loaded");

	}

	@Test
	void test_getAllExchangeRateByDate() {
		List<Cube> cur = erf.getAllExchangeRateByDate("2022-09-16");

		Assert.notNull(cur, "rates is loaded");

	}

	@Test
	void test_getAllExchangeRateByDate_1() {
		try {
			List<Cube> cur = erf.getAllExchangeRateByDate(null);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	@Test
	void test_getAllExchangeRateByDate_2() {
		List<Cube> cur = erf.getAllExchangeRateByDate("2022-09-12");

		Assert.notNull(cur, "rates is loaded");

	}

	@Test
	void test_getCurrencyInEUR() {
		double cur = erf.getCurrencyInEUR("USD");

		Assert.notNull(cur, "rates is loaded");

	}

	@Test
	void test_getCurrencyInEUR_1() {
		double cur = erf.getCurrencyInEUR("USD", "2022-09-12");

		Assert.notNull(cur, "rates is loaded");

	}

	@Test
	void test_getTodayExchangeRate() {
		List<Cube> cur = erf.getTodayExchangeRate();

		Assert.notNull(cur, "rates is loaded");

	}

}

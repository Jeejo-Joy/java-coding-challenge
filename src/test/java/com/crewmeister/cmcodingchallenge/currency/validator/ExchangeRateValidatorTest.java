package com.crewmeister.cmcodingchallenge.currency.validator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import com.crewmeister.cmcodingchallenge.loader.CurrencyLoader;

class ExchangeRateValidatorTest {

	private ExchangeRateValidator erv = new ExchangeRateValidator();

	@BeforeEach
	public void name() {
		CurrencyLoader.load("classpath:eurofxref-hist-90d.xml");
		CurrencyLoader.createDS();
	}

	@Test
	void test_isValidDate() {
		try {
			Assert.isTrue(erv.isValidDate(null) == false, "null date");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	void test_isValidDate_1() {

		Assert.isTrue(erv.isValidDate("2022-09-16") == true, "valid date");
	}

	@Test
	void test_isValidDate_2() {

		Assert.isTrue(erv.isValidDate("2022-09-51") == false, "invalid date");
	}

	@Test
	void test_isValidCurrency() {

		Assert.isTrue(erv.isValidCurrency("ABB") == false, "invalid currency");
	}

	@Test
	void test_isValidCurrency_2() {

		Assert.isTrue(erv.isValidCurrency(null) == false, "invalid currency");
	}

	@Test
	void test_isValidCurrency_3() {

		Assert.isTrue(erv.isValidCurrency("    ") == false, "invalid currency");
	}

	@Test
	void test_isValidCurrency_4() {

		Assert.isTrue(erv.isValidCurrency("USD") == true, "valid currency");
	}

	@Test
	void test_isBlankDate() {
		try {
			Assert.isTrue(erv.isBlankDate(" ") == true, "in valid date");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	void test_isBlankDate_1() {

		Assert.isTrue(erv.isBlankDate(null) == true, "in valid date");
	}

	@Test
	void test_isValidValue_1() {

		Assert.isTrue(erv.isValidValue(null) == false, "in valid value");
	}

	@Test
	void test_isValidValue_2() {

		Assert.isTrue(erv.isValidValue("1.00") == true, "valid value");
	}
}

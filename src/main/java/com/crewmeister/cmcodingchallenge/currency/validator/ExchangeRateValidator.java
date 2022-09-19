package com.crewmeister.cmcodingchallenge.currency.validator;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.util.StringUtils;

import com.crewmeister.cmcodingchallenge.loader.CurrencyLoader;

public class ExchangeRateValidator {

	private DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

	public boolean isValidDate(String pdate) {
		formatter.setLenient(false);

		try {
			formatter.parse(pdate);
			return true;
		} catch (ParseException e) {
			// If input date is in different format or invalid.
			return false;
		}
	}

	public boolean isValidCurrency(String currency) {

		if (currency == null || !StringUtils.hasLength(currency)) {
			return false;
		}

		if (CurrencyLoader.getCurrencies().contains(currency)) {
			return true;
		}

		return false;
	}

	public boolean isBlankDate(String date) {
		return date == null || !StringUtils.hasLength(date);
	}

	public boolean isValidValue(String value) {
		
		if (isBlankDate(value)) {
			return false;
		}
		Double.valueOf(value);
		return true;
	}

}

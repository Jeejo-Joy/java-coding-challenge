package com.crewmeister.cmcodingchallenge.currency.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crewmeister.cmcodingchallenge.currency.dto.ErrorWsDTO;
import com.crewmeister.cmcodingchallenge.currency.facade.ExchangeRateFacade;
import com.crewmeister.cmcodingchallenge.currency.facade.ExchangeRateFacadeImpl;
import com.crewmeister.cmcodingchallenge.currency.validator.ExchangeRateValidator;
import com.crewmeister.cmcodingchallenge.loader.Cube;

@RestController()
@RequestMapping("/api")
public class CurrencyController {

	private ExchangeRateValidator validator = new ExchangeRateValidator();

	/**
	 * 
	 * @return As a client, I want to get a list of all available currencies
	 */
	@GetMapping("/currencies")
	public ResponseEntity<ArrayList<String>> getCurrencies() {
		ExchangeRateFacade erf = new ExchangeRateFacadeImpl();

		return new ResponseEntity<>(new ArrayList<>(erf.getCurrencies()), HttpStatus.OK);
	}

	/**
	 * @return As a client, I want to get all EUR-FX exchange rates at all available
	 *         dates as a collection
	 */
	@GetMapping(value = { "/exchange-rates" })
	public ResponseEntity<HashMap<String, List<Cube>>> getAllExchangeRates() {

		ExchangeRateFacade erf = new ExchangeRateFacadeImpl();
		Map<String, List<Cube>> p = erf.getAllExchangeRates();
		return new ResponseEntity<>((HashMap<String, List<Cube>>) p, HttpStatus.OK);
	}

	/**
	 * @return As a client, I want to get the EUR-FX exchange rate at particular day
	 */
	@SuppressWarnings("unchecked")
	@GetMapping("/exchange-rates/{date}")
	public ResponseEntity<List<Cube>> getAllExchangeRatesByDate(
			@PathVariable(required = true, name = "date") String date) {

		if (!validator.isValidDate(date)) {
			return getUnsuccessfulResponseWithErrorRepresentation("Invalid Date", HttpStatus.BAD_REQUEST);

		}

		ExchangeRateFacade erf = new ExchangeRateFacadeImpl();
		List<Cube> p = erf.getAllExchangeRateByDate(date);

		if (p == null) {
			return getUnsuccessfulResponseWithErrorRepresentation("NO Content, Invalid Date", HttpStatus.BAD_REQUEST);

		}
		return new ResponseEntity<>(p, HttpStatus.OK);
	}

	/**
	 * @return As a client, I want to get a foreign exchange amount for a given
	 *         currency converted to EUR on a particular day
	 * 
	 */
	@SuppressWarnings("unchecked")
	@GetMapping(value = { "/convert/{currency}/{value}", "/convert/{currency}/{value}" })
	public ResponseEntity<Double> getCurrencyInEUR(@PathVariable(required = false, name = "currency") String currency,
			@PathVariable(required = true, name = "value") String value) {

		if (!validator.isValidValue(value)) {
			return getUnsuccessfulResponseWithErrorRepresentation("Invalid Value", HttpStatus.BAD_REQUEST);

		}

		if (!validator.isValidCurrency(currency)) {
			return getUnsuccessfulResponseWithErrorRepresentation("Invalid Currency", HttpStatus.BAD_REQUEST);

		}

		ExchangeRateFacade erf = new ExchangeRateFacadeImpl();
		double rate = erf.getCurrencyInEUR(currency);

		return new ResponseEntity<>(Double.valueOf(value) * rate, HttpStatus.OK);
	}

	/**
	 * @return As a client, I want to get a foreign exchange amount for a given
	 *         currency converted to EUR on a particular day
	 * 
	 */
	@SuppressWarnings("unchecked")
	@GetMapping(value = { "/convert/{currency}/{value}/{date}", "/convert/{currency}/{value}/{date}" })
	public ResponseEntity<Double> getCurrencyInEURByDate(
			@PathVariable(required = false, name = "currency") String currency,
			@PathVariable(required = true, name = "value") String value,
			@PathVariable(required = false, name = "date") String date) {

		if (!validator.isValidValue(value)) {
			return getUnsuccessfulResponseWithErrorRepresentation("Invalid Value", HttpStatus.BAD_REQUEST);
		}

		if (!validator.isValidCurrency(currency)) {
			return getUnsuccessfulResponseWithErrorRepresentation("Invalid Currency", HttpStatus.BAD_REQUEST);
		}
		if (!validator.isValidDate(date)) {
			return getUnsuccessfulResponseWithErrorRepresentation("Invalid date", HttpStatus.BAD_REQUEST);
		}

		ExchangeRateFacade erf = new ExchangeRateFacadeImpl();
		double rate = erf.getCurrencyInEUR(currency, date);

		return new ResponseEntity<>(Double.valueOf(value) * rate, HttpStatus.OK);
	}

	@SuppressWarnings("rawtypes")
	private ResponseEntity getUnsuccessfulResponseWithErrorRepresentation(final String errorMessage,
			final HttpStatus httpStatus) {
		final ErrorWsDTO errorRepresentation = new ErrorWsDTO();
		errorRepresentation.setErrorCode(String.valueOf(httpStatus.value()));
		errorRepresentation.setReason(errorMessage);

		return new ResponseEntity<>(errorRepresentation, httpStatus);
	}

}

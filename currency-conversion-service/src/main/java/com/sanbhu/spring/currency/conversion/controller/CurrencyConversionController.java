package com.sanbhu.spring.currency.conversion.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.sanbhu.spring.currency.conversion.dto.CurrencyConversion;
import com.sanbhu.spring.currency.conversion.proxy.CurrencyExchangeProxy;

/**
 * The Class CurrencyConversionController.
 */
@RestController
public class CurrencyConversionController {
	
	/** The proxy. */
	@Autowired
	private CurrencyExchangeProxy proxy;

	/**
	 * Calculate currency conversion.
	 *
	 * @param from     the from
	 * @param to       the to
	 * @param quantity the quantity
	 * @return the cu 1 rrency conversion
	 */
	@GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion calculateCurrencyConversion(@PathVariable String from, @PathVariable String to,
			@PathVariable Integer quantity) {
		RestTemplate restTemplate = new RestTemplate();
		/*
		 * ResponseEntity<CurrencyConversion> currencyConversionEntity = restTemplate
		 * .getForEntity("http://localhost:8000/currency-exchange/from/USD/to/INR",
		 * CurrencyConversion.class);
		 */
		Map<String, String> pathVariables = new HashMap<String, String>();
		pathVariables.put("from", "USD");
		pathVariables.put("to", "INR");
		ResponseEntity<CurrencyConversion> currencyConversionEntity = restTemplate.getForEntity(
				"http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyConversion.class, pathVariables);
		CurrencyConversion currencyConversion = currencyConversionEntity.getBody();
		if (currencyConversion == null) {
			throw new RuntimeException("Currency Exchange value not found for from " + from + " to " + to);
		}
		/*
		 * return new CurrencyConversion(1L, "USD", "INR", BigDecimal.valueOf(quantity),
		 * BigDecimal.valueOf(10), BigDecimal.valueOf(10), "DEV");
		 */
		currencyConversion.setQuantity(BigDecimal.valueOf(quantity));
		currencyConversion.setTotalCalculatedAmount(
				BigDecimal.valueOf(quantity * currencyConversion.getConversionMultiple().doubleValue()));
		return currencyConversion;
	}
	
	/**
	 * Calculate currency conversion with feign.
	 *
	 * @param from the from
	 * @param to the to
	 * @param quantity the quantity
	 * @return the currency conversion
	 */
	@GetMapping("/currency-conversion-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion calculateCurrencyConversionWithFeign(@PathVariable String from, @PathVariable String to,
			@PathVariable Integer quantity) {
		CurrencyConversion currencyConversion = proxy.fetchCurrenctExchange(from, to);
		
		if (currencyConversion == null) {
			throw new RuntimeException("Currency Exchange value not found for from " + from + " to " + to);
		}
		
		currencyConversion.setQuantity(BigDecimal.valueOf(quantity));
		currencyConversion.setTotalCalculatedAmount(
				BigDecimal.valueOf(quantity * currencyConversion.getConversionMultiple().doubleValue()));
		return currencyConversion;
	}
}

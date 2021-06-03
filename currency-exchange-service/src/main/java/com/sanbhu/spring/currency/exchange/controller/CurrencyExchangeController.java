package com.sanbhu.spring.currency.exchange.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sanbhu.spring.currency.exchange.dto.CurrencyExchange;
import com.sanbhu.spring.currency.exchange.repository.CurrencyExchangeRepository;

/**
 * The Class CurrencyExchangeController.
 */
@RestController
public class CurrencyExchangeController {

	/** The environment. */
	@Autowired
	private Environment environment;
	
	/** The currency exchange repository. */
	@Autowired
	private CurrencyExchangeRepository currencyExchangeRepository;
	
	/**
	 * Retrive exchange value.
	 *
	 * @param from the from
	 * @param to the to
	 * @return the currency exchange
	 */
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyExchange retriveExchangeValue(@PathVariable String from, @PathVariable String to) {
		//CurrencyExchange result = new CurrencyExchange(100L, "USD", "INR", BigDecimal.valueOf(65));
		final CurrencyExchange result = currencyExchangeRepository.findByFromAndTo(from, to);
		final String port = environment.getProperty("local.server.port");
		result.setEnvironment(port);
		return result;
	}
}

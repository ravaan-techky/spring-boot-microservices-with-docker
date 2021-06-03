package com.sanbhu.spring.currency.conversion.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.sanbhu.spring.currency.conversion.dto.CurrencyConversion;

/**
 * The Interface CurrencyExchangeProxy.
 */
/* @FeignClient(name = "currency-exchange", url = "localhost:8000") */
@FeignClient(name = "currency-exchange")
public interface CurrencyExchangeProxy {

	/**
	 * Fetch currenct exchange.
	 *
	 * @param from the from
	 * @param to the to
	 * @return the currency conversion
	 */
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversion fetchCurrenctExchange(@PathVariable String from, @PathVariable String to);
}

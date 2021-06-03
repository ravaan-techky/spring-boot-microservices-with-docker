package com.sanbhu.spring.currency.exchange.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sanbhu.spring.currency.exchange.dto.CurrencyExchange;

/**
 * The Interface CurrencyExchangeRepository.
 */
@Repository
public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange, Long> {

	/**
	 * Find by from and to.
	 *
	 * @param from the from
	 * @param to the to
	 * @return the currency exchange
	 */
	CurrencyExchange findByFromAndTo(final String from, final String to);
}

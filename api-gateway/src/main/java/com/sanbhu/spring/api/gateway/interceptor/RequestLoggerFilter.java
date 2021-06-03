package com.sanbhu.spring.api.gateway.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

/**
 * The Class RequestLoggerFilter.
 */
@Component
public class RequestLoggerFilter implements GlobalFilter {

	/** The Constant LOG. */
	private static final Logger LOG = LoggerFactory.getLogger(RequestLoggerFilter.class);

	/**
	 * Filter.
	 *
	 * @param exchange the exchange
	 * @param chain    the chain
	 * @return the mono
	 */
	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		LOG.info("Request for API ===> {}", exchange.getRequest().getPath());
		return chain.filter(exchange);
	}

}

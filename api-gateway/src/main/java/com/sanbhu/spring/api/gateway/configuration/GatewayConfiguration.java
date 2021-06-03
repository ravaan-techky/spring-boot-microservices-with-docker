package com.sanbhu.spring.api.gateway.configuration;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// TODO: Auto-generated Javadoc
/**
 * The Class GatewayConfiguration.
 */
@Configuration
public class GatewayConfiguration {

	/**
	 * Gateway router.
	 *
	 * @param builder the builder
	 * @return the route locator
	 */
	@Bean
	public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(p -> p.path("/get")
						.filters(f -> f.addRequestHeader("MyCustomHeader", "MyCustomHeaderValue")
								.addRequestParameter("RequestParam", "RequestParamValue"))
						.uri("http://httpbin.org:80/"))
				.route(p -> p.path("/currency-exchange/**").uri("lb://currency-exchange/"))
				.build();
	}
}

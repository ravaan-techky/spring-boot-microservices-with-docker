package com.sanbhu.spring.currency.conversion.dto;

import java.math.BigDecimal;

// TODO: Auto-generated Javadoc
/**
 * The Class CurrencyConversion.
 */
public class CurrencyConversion {

	/** The id. */
	private Long id;

	/** The from. */
	private String from;

	/** The to. */
	private String to;

	/** The quantity. */
	private BigDecimal quantity;
	
	/** The conversion multiple. */
	private BigDecimal conversionMultiple;

	/** The total calculated amount. */
	private BigDecimal totalCalculatedAmount;

	/** The environment. */
	private String environment;

	/**
	 * Instantiates a new cu 1 rrency conversion.
	 */
	public CurrencyConversion() {
		super();
	}

	/**
	 * Instantiates a new cu 1 rrency conversion.
	 *
	 * @param id                    the id
	 * @param from                  the from
	 * @param to                    the to
	 * @param quantity              the quantity
	 * @param conversionMultiple    the conversion multiple
	 * @param totalCalculatedAmount the total calculated amount
	 * @param environment           the environment
	 */
	public CurrencyConversion(Long id, String from, String to, BigDecimal quantity, BigDecimal conversionMultiple,
			BigDecimal totalCalculatedAmount, String environment) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.conversionMultiple = conversionMultiple;
		this.quantity = quantity;
		this.totalCalculatedAmount = totalCalculatedAmount;
		this.environment = environment;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Gets the from.
	 *
	 * @return the from
	 */
	public String getFrom() {
		return from;
	}

	/**
	 * Sets the from.
	 *
	 * @param from the new from
	 */
	public void setFrom(String from) {
		this.from = from;
	}

	/**
	 * Gets the to.
	 *
	 * @return the to
	 */
	public String getTo() {
		return to;
	}

	/**
	 * Sets the to.
	 *
	 * @param to the new to
	 */
	public void setTo(String to) {
		this.to = to;
	}

	/**
	 * Gets the conversion multiple.
	 *
	 * @return the conversion multiple
	 */
	public BigDecimal getConversionMultiple() {
		return conversionMultiple;
	}

	/**
	 * Sets the conversion multiple.
	 *
	 * @param conversionMultiple the new conversion multiple
	 */
	public void setConversionMultiple(BigDecimal conversionMultiple) {
		this.conversionMultiple = conversionMultiple;
	}

	/**
	 * Gets the quantity.
	 *
	 * @return the quantity
	 */
	public BigDecimal getQuantity() {
		return quantity;
	}

	/**
	 * Sets the quantity.
	 *
	 * @param quantity the new quantity
	 */
	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	/**
	 * Gets the total calculated amount.
	 *
	 * @return the total calculated amount
	 */
	public BigDecimal getTotalCalculatedAmount() {
		return totalCalculatedAmount;
	}

	/**
	 * Sets the total calculated amount.
	 *
	 * @param totalCalculatedAmount the new total calculated amount
	 */
	public void setTotalCalculatedAmount(BigDecimal totalCalculatedAmount) {
		this.totalCalculatedAmount = totalCalculatedAmount;
	}

	/**
	 * Gets the environment.
	 *
	 * @return the environment
	 */
	public String getEnvironment() {
		return environment;
	}

	/**
	 * Sets the environment.
	 *
	 * @param environment the new environment
	 */
	public void setEnvironment(String environment) {
		this.environment = environment;
	}
}
